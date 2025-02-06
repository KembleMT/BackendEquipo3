package org.generation.BrickMania.producto.model;

import javax.persistence.*;

@Entity
@Table(name = "Estados_Pedido")
public class EstadoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Long id;

    @Column(name = "estado", nullable = false, unique = true, length = 50)
    private String estado;

    // Constructor vacío 
    public EstadoPedido() {
    }

    // Constructor con parámetros
    public EstadoPedido(String estado) {
    	super();
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //toString
	@Override
	public String toString() {
		return "EstadoPedido [id=" + id + ", estado=" + estado + "]";
	}
    
}

