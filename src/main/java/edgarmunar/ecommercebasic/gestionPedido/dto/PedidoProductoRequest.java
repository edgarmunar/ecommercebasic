package edgarmunar.ecommercebasic.gestionPedido.dto;

public class PedidoProductoRequest {

    private Long productoId;
    private Integer cantidad;
    private Integer subtotal;

    public PedidoProductoRequest() {
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }
}