package org.generation.BrickMania.controller;

import org.generation.BrickMania.producto.model.Usuarios;
import org.generation.BrickMania.repository.UsuariosRepository;

import java.util.Optional;

import org.generation.BrickMania.config.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login/")
public class LoginController {

    private final UsuariosRepository usuariosRepository;
    private final JwtUtil jwtUtil;

    public LoginController(UsuariosRepository usuarioRepository, JwtUtil jwtUtil) {
        this.usuariosRepository = usuarioRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuarios usuario) {
        Optional<Usuarios> user = usuariosRepository.findByEmail(usuario.getEmail());

        if (user == null || !user.get().comparePassword1(usuario.getContraseña())) {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }

        String token = jwtUtil.generateToken(user.get().getEmail());
        return ResponseEntity.ok(token);
    }
}
