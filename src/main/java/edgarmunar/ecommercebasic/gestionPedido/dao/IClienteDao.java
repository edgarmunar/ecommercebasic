package edgarmunar.ecommercebasic.gestionPedido.dao;

import org.springframework.data.repository.CrudRepository;

import edgarmunar.ecommercebasic.gestionPedido.models.entities.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long>{

}
