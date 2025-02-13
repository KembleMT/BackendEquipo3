package org.generation.BrickMania.controller;

import org.generation.BrickMania.producto.model.Usuarios;
import org.generation.BrickMania.repository.UsuariosRepository;

import java.util.Optional;

import org.generation.BrickMania.config.JwtUtil;
import org.generation.BrickMania.config.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public ResponseEntity<?> login(@RequestBody Login loginRequest) {
        System.out.println("Intento de login con email: " + loginRequest.getEmail());

        Optional<Usuarios> user = usuariosRepository.findByEmail(loginRequest.getEmail());

        if (!user.isPresent()) {
            System.out.println("Usuario no encontrado.");
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }

        Usuarios usuarioEncontrado = user.get();

        //Verifica si la contraseña está llegando en texto plano
        System.out.println("Contraseña en texto plano ingresada: " + loginRequest.getPassword());
        System.out.println("Contraseña almacenada en la BD (hash): " + usuarioEncontrado.getContraseña());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (!encoder.matches(loginRequest.getPassword(), usuarioEncontrado.getContraseña())) {
            System.out.println("Contraseña incorrecta. No coinciden.");
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }

        String token = jwtUtil.generateToken(usuarioEncontrado.getEmail());
        System.out.println("Login exitoso, token generado.");

        return ResponseEntity.ok(token);
    }

}      
