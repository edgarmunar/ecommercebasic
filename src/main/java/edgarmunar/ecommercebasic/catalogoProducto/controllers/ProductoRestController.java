package edgarmunar.ecommercebasic.catalogoProducto.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edgarmunar.ecommercebasic.catalogoProducto.models.entities.Producto;
import edgarmunar.ecommercebasic.catalogoProducto.models.services.IProductoService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")

public class ProductoRestController {

    @Autowired
	private IProductoService productoService;
	
	@GetMapping("/productos")
	public List<Producto> index(){
		
		return productoService.findAll();		
	}

	@GetMapping("/producto/{id}")
	public ResponseEntity<?> mostrar(@PathVariable Long id){

		Producto producto = null;
		Map<String, Object> response = new HashMap<>();
        
		try {
            Optional<Producto> optionalProducto = productoService.findById(id);	

            if(optionalProducto.isPresent()){
                producto = optionalProducto.orElseThrow();
            }else{
                response.put("mensaje","El Producto ".concat(id.toString()).concat(" no se encuentra registrado en el sistema"));
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
            }
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta por id");
			response.put("error", e.getMessage().concat(" : null").concat(e.getMostSpecificCause().getMessage()));		
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}

	@PostMapping("/productos")
	public ResponseEntity<?> crear(@Valid @RequestBody Producto producto, BindingResult result){ 

		Producto productoNuevo = null;
		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()){
			
			List<String> errors = new ArrayList<>();

			for(FieldError err: result.getFieldErrors()){
				errors.add("El campo '"+err.getField()+"' "+err.getDefaultMessage());
			}

			response.put("errors", errors);
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
		}

		try {
			productoNuevo = productoService.save(producto);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la creación del producto");
			response.put("error", e.getMessage().concat(" : null").concat(e.getMostSpecificCause().getMessage()));		
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje","El producto ha sido creado con exito!!");
		response.put("producto",productoNuevo);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}

	@PutMapping("/productos/{id}")
	public ResponseEntity<?> modificar(@Valid @RequestBody Producto producto, BindingResult result, @PathVariable Long id) {
		
		Producto productoActual = null;
		Producto productoUpdate = null;
		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()){
			List<String> errors = new ArrayList<>();

			for(FieldError err: result.getFieldErrors()){
				errors.add("El campo '"+err.getField()+"' "+err.getDefaultMessage());
			}
			response.put("errors", errors);
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
		}

        Optional<Producto> optionalProducto = productoService.findById(id);	

        if(optionalProducto.isPresent()){
            productoActual = optionalProducto.orElseThrow();
        }else{
            response.put("mensaje","Error: No se puede actualizar, el Producto ".concat(id.toString()).concat(" no se encuentra registrado en el sistema"));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }

		try {

            productoActual.setNombreProd(producto.getNombreProd());
            productoActual.setCategoriaProd(producto.getCategoriaProd());
            productoActual.setDescripProd(producto.getDescripProd());
			
			productoUpdate = productoService.save(productoActual);						
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la modificación del producto en la base de datos");
			response.put("error", e.getMessage().concat(" : null").concat(e.getMostSpecificCause().getMessage()));		
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El producto ha sido Modificado con exito!!");
		response.put("producto",productoUpdate);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}

	@DeleteMapping("/productos/{id}")
	public ResponseEntity<?> borrar(@PathVariable Long id){

		Map<String, Object> response = new HashMap<>();

        Optional<Producto> optionalProducto = productoService.findById(id);	

        if(optionalProducto.isPresent()){
            
            try {
                productoService.delete(id);	
            } catch (DataAccessException e) {
                response.put("mensaje", "Error no se puede eliminar el producto en la base de datos");
                response.put("error", e.getMessage().concat(" : null").concat(e.getMostSpecificCause().getMessage()));		
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
            }	
            response.put("mensaje","Producto "+id+" eliminado con exito!!");
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);

        }else{
            response.put("mensaje","Error: No se puede eliminar, el Producto ".concat(id.toString()).concat(" no se encuentra registrado en el sistema"));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }	
	}	
}
