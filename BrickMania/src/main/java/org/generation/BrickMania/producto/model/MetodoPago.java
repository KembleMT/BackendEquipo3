package org.generation.BrickMania.producto.model;

import javax.persistence.*;

@Entity
@Table(name = "Metodos_Pago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo")
    private Integer id;

    @Column(name = "metodo", nullable = false, unique = true, length = 50)
    private String metodo;

    // Constructor vacío 
    public MetodoPago() {
    }

    // Constructor con parámetros
    public MetodoPago(String metodo) {
        super();
        this.metodo = metodo;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    //toString
    @Override
    public String toString() {
        return "MetodoPago [id=" + id + ", metodo=" + metodo + "]";
    }
}
