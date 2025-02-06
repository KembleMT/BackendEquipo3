package org.generation.BrickMania.producto.model;

import org.generation.BrickMania.producto.model; //importacion de usuario revisar si esta correcta para que no marque error

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;

    // Relación con Usuario: un pedido pertenece a un usuario.
    @ManyToOne
    @JoinColumn(name = "id_usuario_fk", nullable = false)
    private Usuario usuario;

    @Column(name = "total_pago", nullable = false)
    private Double totalPago;

    @Column(name = "fecha_compra", nullable = false)
    private LocalDate fechaCompra;

    @Column(name = "id_metodo_fk", nullable = false)
    private Integer idMetodoFk;

    @Column(name = "id_estado_fk", nullable = false)
    private String idEstadoFk;

    // Constructores
    public Pedido() {}

    public Pedido(Usuario usuario, Double totalPago, LocalDate fechaCompra, Integer idMetodoFk, String idEstadoFk) {
        super();
    	this.usuario = usuario;
        this.totalPago = totalPago;
        this.fechaCompra = fechaCompra;
        this.idMetodoFk = idMetodoFk;
        this.idEstadoFk = idEstadoFk;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public Double getTotalPago() {
        return totalPago;
    }
    public void setTotalPago(Double totalPago) {
        this.totalPago = totalPago;
    }
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    public Integer getIdMetodoFk() {
        return idMetodoFk;
    }
    public void setIdMetodoFk(Integer idMetodoFk) {
        this.idMetodoFk = idMetodoFk;
    }
    public String getIdEstadoFk() {
        return idEstadoFk;
    }
    public void setIdEstadoFk(String idEstadoFk) {
        this.idEstadoFk = idEstadoFk;
    }
     
    //toString
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", totalPago=" + totalPago + ", fechaCompra=" + fechaCompra + ", idMetodoFk="
				+ idMetodoFk + ", idEstadoFk=" + idEstadoFk + "]";
	}
    
    
}
