package edgarmunar.ecommercebasic.catalogoProducto.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edgarmunar.ecommercebasic.catalogoProducto.models.dao.IProductoDao;
import edgarmunar.ecommercebasic.catalogoProducto.models.entities.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private IProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> findById(Long id) {
        
        return productoDao.findById(id);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productoDao.deleteById(id);       
    }

}
