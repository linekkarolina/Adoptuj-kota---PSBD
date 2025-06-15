package org.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // dla wszystkich endpointów
                .allowedOrigins("*") // <- tu ustawiasz Access-Control-Allow-Origin: *
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}