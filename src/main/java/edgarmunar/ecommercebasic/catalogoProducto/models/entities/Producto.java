package edgarmunar.ecommercebasic.catalogoProducto.models.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prod;

    @NotEmpty(message="Nombre es requerido!")
	@Column(nullable = false)
    private String nombreProd;

    @NotEmpty(message="Categoria es requerido!")
    @Column(nullable = false)
    private String categoriaProd;

    @NotEmpty(message="Descripcion es requerido!")
    @Column(nullable = false)
    private String descripProd;

    public Long getId_prod() {
        return id_prod;
    }

    public void setId_prod(Long id_prod) {
        this.id_prod = id_prod;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getCategoriaProd() {
        return categoriaProd;
    }

    public void setCategoriaProd(String categoriaProd) {
        this.categoriaProd = categoriaProd;
    }

    public String getDescripProd() {
        return descripProd;
    }

    public void setDescripProd(String descripProd) {
        this.descripProd = descripProd;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;
}
