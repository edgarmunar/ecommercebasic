package edgarmunar.ecommercebasic.gestionPedido.dao;

import org.springframework.data.repository.CrudRepository;

import edgarmunar.ecommercebasic.gestionPedido.models.entities.Pedido;

public interface IPedidoDao extends CrudRepository<Pedido,Long>{

}
