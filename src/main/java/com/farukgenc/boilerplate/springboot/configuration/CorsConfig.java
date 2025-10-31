package com.farukgenc.boilerplate.springboot.configuration;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cfg = new CorsConfiguration();

        // Origines autorisées (front Vite en dev)
        cfg.setAllowedOrigins(List.of("http://localhost:5173"));

        // Méthodes HTTP autorisées
        cfg.setAllowedMethods(List.of("GET","POST","PUT","PATCH","DELETE","OPTIONS"));

        // Headers acceptés en entrée
        cfg.setAllowedHeaders(List.of("Authorization","Content-Type","X-Requested-With"));

        // Headers exposés côté réponse (optionnel)
        cfg.setExposedHeaders(List.of("Authorization"));

        // Tu utilises un JWT dans Authorization (pas de cookie), donc false.
        cfg.setAllowCredentials(false);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Appliquer à toutes les routes
        source.registerCorsConfiguration("/**", cfg);
        return source;
    }
}
