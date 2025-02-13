package org.generation.BrickMania.config;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBCrypt {
    public static void main(String[] args) {
        String rawPassword = "MariaPerez2025!";
        String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
        System.out.println("Contraseña encriptada: " + encodedPassword);
    }
}