package org.generation.BrickMania.producto.model;

import javax.persistence.*;
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

    // Corrección: Cambio de Integer a EstadoPedido para la relación ManyToOne
    @ManyToOne
    @JoinColumn(name = "id_estado_fk", nullable = false)
    private EstadoPedido estadoPedido;

    // Constructores
    public Pedido() {}

    public Pedido(Usuarios usuario, Double totalPago, LocalDate fechaCompra, Integer idMetodoFk, EstadoPedido estadoPedido) {
        super();
        this.usuario = usuario;
        this.totalPago = totalPago;
        this.fechaCompra = fechaCompra;
        this.idMetodoFk = idMetodoFk;
        this.estadoPedido = estadoPedido;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
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

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    // toString
    @Override
    public String toString() {
        return "Pedido [id=" + id + ", usuario=" + usuario + ", totalPago=" + totalPago 
                + ", fechaCompra=" + fechaCompra + ", idMetodoFk=" + idMetodoFk 
                + ", estadoPedido=" + estadoPedido + "]";
    }
}

