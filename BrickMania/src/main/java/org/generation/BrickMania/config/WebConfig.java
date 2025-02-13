package org.generation.BrickMania.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Permite las rutas que empiezan con /api/
                        .allowedOrigins("http://127.0.0.1:5501", "http://localhost:5501") // Direcciones permitidas
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                        .allowCredentials(true); // Asegura compatibilidad con CORS
            }
        };
    }
}

