package edgarmunar.ecommercebasic.gestionPedido.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_clie;

    @NotEmpty(message="Nombre es requerido!")
	@Column(nullable = false)
    private String nombreClie;

    @NotEmpty(message="Apellido es requerido!")
	@Column(nullable = false)
    private String apellidoClie;

    @NotEmpty(message="Email es requerido!")
	@Email
	@Column(nullable = false,unique = true)
	private String email;

    public Cliente() {
    }

    public Long getId_clie() {
        return id_clie;
    }

    public void setId_clie(Long id_clie) {
        this.id_clie = id_clie;
    }

    public String getNombreClie() {
        return nombreClie;
    }

    public void setNombreClie(String nombreClie) {
        this.nombreClie = nombreClie;
    }

    public String getApellidoClie() {
        return apellidoClie;
    }

    public void setApellidoClie(String apellidoClie) {
        this.apellidoClie = apellidoClie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}