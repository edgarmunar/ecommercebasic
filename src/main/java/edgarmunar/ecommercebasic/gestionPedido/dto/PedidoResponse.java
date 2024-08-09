package edgarmunar.ecommercebasic.gestionPedido.dto;

import java.util.List;

import edgarmunar.ecommercebasic.gestionPedido.models.entities.Cliente;
import edgarmunar.ecommercebasic.gestionPedido.models.entities.PedidoProducto;

public class PedidoResponse {

    private Long id_pedido;
    private Cliente cliente;
    private List<PedidoProducto> pedidoProductos;
    private Integer valorTotal;

    public PedidoResponse() {
    }

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<PedidoProducto> getPedidoProductos() {
        return pedidoProductos;
    }

    public void setPedidoProductos(List<PedidoProducto> pedidoProductos) {
        this.pedidoProductos = pedidoProductos;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }
}