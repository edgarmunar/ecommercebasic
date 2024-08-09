package edgarmunar.ecommercebasic.gestionPedido.models.services;

import java.util.List;
import java.util.Optional;

import edgarmunar.ecommercebasic.gestionPedido.models.entities.Cliente;

public interface IClienteService {

    public List<Cliente> findAll();

	public Optional<Cliente> findById(Long id);

	public Cliente save(Cliente cliente);

	public void delete(Long id);	
}