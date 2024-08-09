package edgarmunar.ecommercebasic.gestionPedido.models.services;

import java.util.List;
import java.util.Optional;

import edgarmunar.ecommercebasic.gestionPedido.models.entities.Pedido;

public interface IPedidoService {

    public List<Pedido> findAll();

	public Optional<Pedido> findById(Long id);

	public Pedido save(Pedido pedidoProducto);

	public void delete(Long id);	
}