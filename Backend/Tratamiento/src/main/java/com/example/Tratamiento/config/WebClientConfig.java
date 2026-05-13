package com.example.Tratamiento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient consultaMedicaWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:6161")
                .build();
        
    }
}
