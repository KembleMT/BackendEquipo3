package org.generation.BrickMania.producto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Entity
@Table(name = "Usuarios")
public class Usuarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String contraseña;
    
    private String direccion;

    @JoinColumn(name = "id_rol_fk", nullable = false)
    private Integer id_rol_fk;

    // Constructor vacío
    public Usuarios() {
        this.id_rol_fk = 2; 
    }

    // Constructor con parámetros
    public Usuarios(String nombre, String email, String contraseña, String direccion, Integer id_rol_fk) {
    	super();
        this.nombre = nombre;
        this.email = email;
        setContraseña(contraseña);
        this.direccion = direccion;
        this.id_rol_fk = (id_rol_fk != null) ? id_rol_fk : 2; //para registrar ADMIN hacerlo manual desde MySQL
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        if (!contraseña.startsWith("$2a$")) { // Evita encriptar si ya está encriptado
            this.contraseña = new BCryptPasswordEncoder().encode(contraseña);
        } else {
            this.contraseña = contraseña;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getId_rol_fk() {
        return id_rol_fk;
    }

    public void setId_rol_fk(Integer id_rol_fk) {
        this.id_rol_fk = id_rol_fk;
    }

    // Método para verificar la contraseña
    public boolean comparePassword(String rawPassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, this.contraseña);
    }

    @Override
    public String toString() {
        return "Usuarios [id=" + id + ", nombre=" + nombre + ", email=" + email + ", contraseña=" + contraseña
                + ", direccion=" + direccion + ", id_rol_fk=" + id_rol_fk + "]";
    }
}

