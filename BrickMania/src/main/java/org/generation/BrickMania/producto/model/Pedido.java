package org.generation.BrickMania.producto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;

    // Relación con Usuario: un pedido pertenece a un usuario.
    @ManyToOne
    @JoinColumn(name = "id_usuario_fk", nullable = false)
    private Usuarios usuario;

    @Column(name = "total_pago", nullable = false)
    private Double totalPago;

    @Column(name = "fecha_compra", nullable = false)
    private LocalDate fechaCompra;

    @Column(name = "id_metodo_fk", nullable = false)
    private Integer idMetodoFk;

    @ManyToOne
    @JoinColumn(name = "id_estado_fk", nullable = false)
    private Integer idEstadoFk;

    // Constructores
    public Pedido() {}

    public Pedido(Usuarios usuario, Double totalPago, LocalDate fechaCompra, Integer idMetodoFk, Integer idEstadoFk) {
        super();
    	this.usuario = usuario;
        this.totalPago = totalPago;
        this.fechaCompra = fechaCompra;
        this.idMetodoFk = idMetodoFk;
        this.idEstadoFk = idEstadoFk;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }
    public Usuarios getUsuario() {
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
    public Integer getIdEstadoFk() {
        return idEstadoFk;
    }
    public void setIdEstadoFk(Integer idEstadoFk) {
        this.idEstadoFk = idEstadoFk;
    }
     
    //toString
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", totalPago=" + totalPago + ", fechaCompra=" + fechaCompra + ", idMetodoFk="
				+ idMetodoFk + ", idEstadoFk=" + idEstadoFk + "]";
	}
    
    
}
