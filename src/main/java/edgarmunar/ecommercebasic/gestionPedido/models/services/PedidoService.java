package edgarmunar.ecommercebasic.gestionPedido.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edgarmunar.ecommercebasic.gestionPedido.dao.IPedidoDao;
import edgarmunar.ecommercebasic.gestionPedido.models.entities.Pedido;

@Service
public class PedidoService implements IPedidoService{

    @Autowired
    private IPedidoDao pedido;

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Pedido> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    
    @Override
    @Transactional(readOnly = true)
    public Optional<Pedido> findById(Long id) {
        return pedido.findById(id);
    }

    @Override
    @Transactional
    public Pedido save(Pedido pedidoProducto) {
        return pedido.save(pedidoProducto);
    }
}