package edgarmunar.ecommercebasic.catalogoProducto.models.services;

import java.util.List;
import java.util.Optional;

import edgarmunar.ecommercebasic.catalogoProducto.models.entities.Producto;

public interface IProductoService{

    public List<Producto> findAll();

	public Optional<Producto> findById(Long id);

	public Producto save(Producto producto);

	public void delete(Long id);	
}