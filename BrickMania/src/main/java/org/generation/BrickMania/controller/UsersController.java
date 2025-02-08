package org.generation.BrickMania.controller;

import java.util.List;

import org.generation.BrickMania.producto.model.Usuarios;
import org.generation.BrickMania.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/usuarios/")
public class UsersController {

    private final UsuariosService usuariosService;

    @Autowired
    public UsersController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    // 1. Obtener todos los usuarios
    @GetMapping
    public List<Usuarios> getUsuarios() {
        return usuariosService.getAllUsuarios();
    }

    // 2. Obtener un usuario por ID
    @GetMapping(path = "{userId}")
    public Usuarios getUsuario(@PathVariable("userId") Integer id) {
        return usuariosService.getUsuario(id);
    }

    // 3. Agregar un nuevo usuario
    @PostMapping
    public Usuarios addUsuario(@RequestBody Usuarios usuario) {
        return usuariosService.addUsuario(usuario);
    }

    // 4. Eliminar un usuario por ID
    @DeleteMapping(path = "{userId}")
    public Usuarios deleteUsuario(@PathVariable("userId") Integer id) {
        return usuariosService.deleteUsuario(id);
    }

    // 5. Actualizar usuario (ejemplo: cambiar contraseña)
    @PutMapping(path = "{userId}")
    public Usuarios updateUsuario(@PathVariable("userId") Integer id, @RequestBody Usuarios usuario) {
        return usuariosService.updateUsuario(id, usuario);
    }
}