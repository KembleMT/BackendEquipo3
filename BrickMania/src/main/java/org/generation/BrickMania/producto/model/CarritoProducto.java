package org.generation.BrickMania.producto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Carrito_Productos")
public class CarritoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito_producto;

    @ManyToOne
    @JoinColumn(name = "id_usuario_fk", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_producto_fk", nullable = false)
    private Producto producto;

    private int cantidad;

    // Constructor vacío
    public CarritoProducto() {}

    // Constructor con parámetros
    public CarritoProducto(Usuario usuario, Producto producto, int cantidad) {
        this.usuario = usuario;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Long getId_carrito_producto() {
        return id_carrito_producto;
    }

    public void setId_carrito_producto(Long id_carrito_producto) {
        this.id_carrito_producto = id_carrito_producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
