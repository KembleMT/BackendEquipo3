package org.generation.BrickMania.producto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Carrito_Productos")
public class CarritoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Asegura que el ID sea generado automáticamente
    private Integer id_carrito_producto;  // Cambié Long por Integer para coincidir con la base de datos

    @ManyToOne
    @JoinColumn(name = "id_usuario_fk", nullable = false) // Relación con la tabla 'Usuarios'
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_producto_fk", nullable = false) // Relación con la tabla 'Productos'
    private Producto producto;

    private int cantidad;

    // Constructor vacío
    public CarritoProducto() {}

    // Constructor con parámetros
    public CarritoProducto(Usuarios usuario, Producto producto, int cantidad) {
        this.usuario = usuario;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Integer getId_carrito_producto() {
        return id_carrito_producto;
    }

    public void setId_carrito_producto(Integer id_carrito_producto) {
        this.id_carrito_producto = id_carrito_producto;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
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

    @Override
    public String toString() {
        return "CarritoProducto [id_carrito_producto=" + id_carrito_producto + ", usuario=" + usuario + ", producto="
                + producto + ", cantidad=" + cantidad + "]";
    }
}
