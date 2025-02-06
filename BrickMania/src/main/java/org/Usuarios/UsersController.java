package org.generation.BrickMania.controllerU;

import java.util.List;

import org.generation.Brickmania.service.UsuariosService;

@RestController
@RequestMapping(path="/api/Usuarios/")
public class UsuariosController {
private final UsuariosService usuariosService;
	
	@Autowired 
	public ProductoController (UsuariosService usuariosService) {
		super();
		this.usuariosService = usuariosService;
	}
	@GetMapping
	public List<Usuarios> getUsuarios() {
		Usuario usuario = new Usuario("Lego Set City", "Set de construcción de ciudad.", 49.99);
				return UsuariosService.getAllUsuarios;
	}//getProductos

}

