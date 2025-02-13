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
	private String nombre;
	private String email;
	private String contraseña;
	private String direccion;
	
    @JoinColumn(name = "id_rol_fk", nullable = true)
	private Integer id_rol_fk;
	
	
	public Usuarios() {
	}

	public Usuarios(String nombre, String email, String contraseña, String direccion, Integer id_rol_fk) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.contraseña = new BCryptPasswordEncoder().encode(contraseña);
		this.direccion = direccion;
		this.id_rol_fk = id_rol_fk;
	}
	
	public void setPassword(String password) {
        this.contraseña = new BCryptPasswordEncoder().encode(password);
    }

    public boolean comparePassword(String rawPassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, this.contraseña);
    }

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


	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", email=" + email + ", contraseña=" + contraseña
				+ ", direccion=" + direccion + ", id_rol_fk=" + id_rol_fk + "]";
	}
	
	public String getPassword() {
	    return this.contraseña;
	}

	public boolean comparePassword1(String rawPassword) {
	    return new BCryptPasswordEncoder().matches(rawPassword, this.contraseña);
	}
	

}

