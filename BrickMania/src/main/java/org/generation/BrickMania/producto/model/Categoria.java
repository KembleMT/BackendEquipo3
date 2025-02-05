package org.generation.BrickMania.producto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;

    @Column(name = "nombre_categoria", nullable = false, unique = true)
    private String nombre_categoria;

    // Constructor vacío
    public Categoria() {}

    // Constructor con parámetros
    public Categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    // Getters y Setters
    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
}

