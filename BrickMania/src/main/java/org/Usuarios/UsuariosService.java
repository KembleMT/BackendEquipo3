package org.generation.Brickmania.service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuariosService {
	public static List<Usuarios> getAllProducts;
	private final List<Usuarios> Lista= new ArrayList <Usuarios> ();
	
	@Autowired
	public UsuariosService(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}//Autowired UsuariosService
	
	public Usuario getUsuarios (Long id){
		return UsuariosRepository.findById(id).orElseThrow(
		()-> new IllegalArgumentException("El usuario con el id [" + id + "] no existe.")
		);
	}//getUsuario
	
	public Usuario deletUsuarios(Long id) {
		Usuario usua = null;
		if(usuariosRepository.existsById(id)) {
		usua = usuariosRepository.findById(id).get();
		usuariosRepository.deletById(id);
		}//if existById
		return usua;
	}//delet

	public Usuario addUsuarios(Usuarios usuario) {
    	Optional<Usuario> usua =
    	UsuariosRepository.findByNombre(usuario.getNombre());	
		if(usua.isEmpty()) {
			UsuariosRepository.save(usuario);
			return usuario;
	} else {
		return null;
		}
	}//addUsuario
	
	public Usuario updateUsuarios(Long id, String nombre, String email, String contraseña, String direccion,
			Long id_rol_fk) {
		Usuario usua = null;
		if (usuariosRepository.existsById(id)) {
			Usuario usuario = usuariosRepository.findById(id).get();
			if (nombre != null)
				usuario.setNombre(nombre);
			if (email != null)
				usuario.setDescripcion(email);
			if (contraseña != null)
				usuario.setDescripcion(contraseña);
			if (direccion != null)
				usuario.setDescripcion(direccion);
			productosRepository.save(usuario);
			usua = usuario;
		} // if
		return usua;
	}//upDateUsuario
	
	
	
}//UsiariossService
