package edgarmunar.ecommercebasic.gestionPedido.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edgarmunar.ecommercebasic.gestionPedido.dao.IClienteDao;
import edgarmunar.ecommercebasic.gestionPedido.models.entities.Cliente;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;
    
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Cliente> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findById(Long id) {
        return clienteDao.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        // TODO Auto-generated method stub
        return null;
    }
}
