package org.generation.BrickMania.service;

import org.generation.BrickMania.producto.model.Usuarios;
import org.generation.BrickMania.repository.UsuariosRepository;
import org.generation.BrickMania.config.Login;

import java.util.Optional;

import org.generation.BrickMania.config.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UsuariosRepository usuariosRepository;
    private final JwtUtil jwtUtil;

    public LoginService(UsuariosRepository usuariosRepository, JwtUtil jwtUtil) {
        this.usuariosRepository = usuariosRepository;
        this.jwtUtil = jwtUtil;
    }

    public String authenticate(Login request) {
        Optional<Usuarios> usuario = usuariosRepository.findByEmail(request.getEmail());
        if (usuario.isPresent() && new BCryptPasswordEncoder().matches(request.getPassword(), usuario.get().getContraseña())) {
            return jwtUtil.generateToken(usuario.get().getEmail()); 
        }
 else {
            throw new RuntimeException("Credenciales incorrectas");
        }
    }
}
