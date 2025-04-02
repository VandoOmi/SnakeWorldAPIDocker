package de.vando.snakeworld.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Hier wird CORS für alle Endpunkte aktiviert
        registry.addMapping("/**")  // Alle Endpunkte
                .allowedOrigins("*")  // Erlaubte Origins
                .allowedMethods("GET", "POST")  // Erlaubte Methoden
                .allowedHeaders("*");  // Alle Header erlauben
    }
}

