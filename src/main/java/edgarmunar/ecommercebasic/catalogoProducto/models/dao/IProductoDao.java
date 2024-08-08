package edgarmunar.ecommercebasic.catalogoProducto.models.dao;

import org.springframework.data.repository.CrudRepository;

import edgarmunar.ecommercebasic.catalogoProducto.models.entities.Producto;

public interface IProductoDao extends CrudRepository<Producto,Long> {

    

}
