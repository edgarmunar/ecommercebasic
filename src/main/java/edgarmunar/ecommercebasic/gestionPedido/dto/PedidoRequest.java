package edgarmunar.ecommercebasic.gestionPedido.dto;

import java.util.List;

public class PedidoRequest {

    private Long id_clie;
    private List<PedidoProductoRequest> pedidoProductos;

    public PedidoRequest() {
    }

    public Long getId_clie() {
        return id_clie;
    }

    public void setId_clie(Long id_clie) {
        this.id_clie = id_clie;
    }

    public List<PedidoProductoRequest> getPedidoProductos() {
        return pedidoProductos;
    }

    public void setPedidoProductos(List<PedidoProductoRequest> pedidoProductos) {
        this.pedidoProductos = pedidoProductos;
    }
}