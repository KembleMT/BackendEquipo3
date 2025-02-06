package org.generation.BrickMania.producto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Usuarios")
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String email;
	private String contraseña;
	private String direccion;
	private Long id_rol_fk;
	
	
	
	public Usuarios(String nombre, String email, String contraseña, String direccion) {
		this.nombre = nombre;
		this.email = email;
		this.contraseña = contraseña;
		this.direccion = direccion;
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
		this.contraseña = contraseña;
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


}

