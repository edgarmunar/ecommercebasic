package edgarmunar.ecommercebasic.gestionPedido.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edgarmunar.ecommercebasic.catalogoProducto.models.entities.Producto;
import edgarmunar.ecommercebasic.catalogoProducto.models.services.IProductoService;
import edgarmunar.ecommercebasic.gestionPedido.dto.PedidoProductoRequest;
import edgarmunar.ecommercebasic.gestionPedido.dto.PedidoRequest;
import edgarmunar.ecommercebasic.gestionPedido.dto.PedidoResponse;
import edgarmunar.ecommercebasic.gestionPedido.models.entities.Cliente;
import edgarmunar.ecommercebasic.gestionPedido.models.entities.Pedido;
import edgarmunar.ecommercebasic.gestionPedido.models.entities.PedidoProducto;
import edgarmunar.ecommercebasic.gestionPedido.models.services.IClienteService;
import edgarmunar.ecommercebasic.gestionPedido.models.services.IPedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRestController {

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IPedidoService pedidoService;

    @PostMapping("/grabar")
    public ResponseEntity<?> grabarPedido(@RequestBody PedidoRequest pedidoRequest) {

        Cliente clienteActual = null;
        Map<String, Object> response = new HashMap<>();
        Optional<Cliente> optionalCliente = clienteService.findById(pedidoRequest.getId_clie());	
        
        if(optionalCliente.isPresent()){
            clienteActual = optionalCliente.orElseThrow();
        }else{
            response.put("mensaje","Error: No se puede grabar el cliente enviado en el pedido no existe.");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }

        Pedido pedido = new Pedido();
        pedido.setCliente(clienteActual);

        for (PedidoProductoRequest ppR : pedidoRequest.getPedidoProductos()) {

            Producto producto =null;
            Optional<Producto> optionalProducto = productoService.findById(ppR.getProductoId());

            if(optionalProducto.isPresent()){
                producto = optionalProducto.orElseThrow();
            }else{
                response.put("mensaje","Error: No se puede grabar, el Producto enviado en el pedido no existe.");
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
            }

            PedidoProducto pedidoProducto = new PedidoProducto();
            pedidoProducto.setProducto(producto);
            pedidoProducto.setCantidad(ppR.getCantidad());
            pedidoProducto.setSubtotal(ppR.getSubtotal());
            pedidoProducto.setPedido(pedido);

            pedido.getPedidoProductos().add(pedidoProducto);
        }

        Pedido grabarPedido = pedidoService.save(pedido);

        PedidoResponse responseDto = new PedidoResponse();
        responseDto.setId_pedido(grabarPedido.getId_pedido());
        responseDto.setCliente(grabarPedido.getCliente());
        responseDto.setPedidoProductos(grabarPedido.getPedidoProductos());
        responseDto.setValorTotal(grabarPedido.getValorTotal());

        response.put("mensaje","El Pedido ha sido grabado con exito!!");
		response.put("respuesta",responseDto);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarPedido(@PathVariable Long id) {
        
        Pedido pedido =null;
        Map<String, Object> response = new HashMap<>();
        Optional<Pedido> optionalPedido = pedidoService.findById(id);

        if(optionalPedido.isPresent()){
            pedido = optionalPedido.orElseThrow();
        }else{
            response.put("mensaje","Error: No se puede consultar, el Pedido enviado no existe.");
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }

        PedidoResponse responseDto = new PedidoResponse();
        responseDto.setId_pedido(pedido.getId_pedido());
        responseDto.setCliente(pedido.getCliente());
        responseDto.setPedidoProductos(pedido.getPedidoProductos());
        responseDto.setValorTotal(pedido.getValorTotal());

        response.put("respuesta",responseDto);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
}
