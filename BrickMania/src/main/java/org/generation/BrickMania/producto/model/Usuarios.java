package org.generation.BrickMania.producto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Entity
@Table(name = "Usuarios")
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String email;
	private String contraseña;
	private String direccion;
	private Integer id_rol_fk;
	
	
	
	public Usuarios(String nombre, String email, String contraseña, String direccion) {
		this.nombre = nombre;
		this.email = email;
		this.contraseña = new BCryptPasswordEncoder().encode(contraseña);
		this.direccion = direccion;
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

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", email=" + email + ", contraseña=" + contraseña
				+ ", direccion=" + direccion + ", id_rol_fk=" + id_rol_fk + "]";
	}

	public Object getPassword() {
		return null;
	}

	public boolean comparePassword1(String contraseña2) {
		return false;
	}


}

