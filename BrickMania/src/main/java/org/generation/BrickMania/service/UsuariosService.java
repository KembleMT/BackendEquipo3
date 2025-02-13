package org.generation.BrickMania.service;

import java.util.List;
import java.util.Optional;

import org.generation.BrickMania.producto.model.Usuarios;
import org.generation.BrickMania.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;

    @Autowired
    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    // 1. Obtener todos los usuarios
    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    // 2. Obtener un usuario por ID
    public Usuarios getUsuario(Integer id) {
        return usuariosRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("El usuario con el id [" + id + "] no existe.")
        );
    }

    // 3. Eliminar un usuario por ID
    public Usuarios deleteUsuario(Integer id) {
        Usuarios usuario = null;
        if (usuariosRepository.existsById(id)) {
            usuario = usuariosRepository.findById(id).get();
            usuariosRepository.deleteById(id);
        }
        return usuario;
    }

    // 4. Agregar un nuevo usuario
    public Usuarios addUsuario(Usuarios usuario) {
        Optional<Usuarios> existingUsuario = usuariosRepository.findByEmail(usuario.getEmail());
        if (existingUsuario.isEmpty()) {
            //Hasheamos la contraseña ANTES de guardarla en la base de datos
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String hashedPassword = encoder.encode(usuario.getContraseña()); // Encripta la contraseña
            usuario.setContraseña(hashedPassword); // Guarda el hash en el usuario

            return usuariosRepository.save(usuario);
        } else {
            return null; 
        }
    }

    // 5. Actualizar usuario
    public Usuarios updateUsuario(Integer id, Usuarios usuario) {
        if (usuariosRepository.existsById(id)) {
            Usuarios existingUsuario = usuariosRepository.findById(id).get();
            if (usuario.getNombre() != null) existingUsuario.setNombre(usuario.getNombre());
            if (usuario.getEmail() != null) existingUsuario.setEmail(usuario.getEmail());
            if (usuario.getContraseña() != null) existingUsuario.setContraseña(usuario.getContraseña());
            if (usuario.getDireccion() != null) existingUsuario.setDireccion(usuario.getDireccion());
            return usuariosRepository.save(existingUsuario);
        }
        return null;
    }

    // 6. Validar usuario por email y contraseña
    public boolean validateUser(Usuarios usuario) {
        Optional<Usuarios> existingUsuario = usuariosRepository.findByEmail(usuario.getEmail());
        if (existingUsuario.isPresent()) {
            return existingUsuario.get().getContraseña().equals(usuario.getContraseña());
        }
        return false;
    }
}