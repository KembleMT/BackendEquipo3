package org.generation.BrickMania.producto.model;

import javax.persistence.*;

@Entity
@Table(name = "Detalles_Pedido")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer id; // Correccion de Long por Integer

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precio", nullable = false)
    private double precio;

    // Constructor vacío 
    public DetallePedido() {
    }

    // Constructor con parámetros
    public DetallePedido(int cantidad, double precio) {
        super();
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //toString
    @Override
    public String toString() {
        return "DetallePedido [id=" + id + ", cantidad=" + cantidad + ", precio=" + precio + "]";
    }
}
