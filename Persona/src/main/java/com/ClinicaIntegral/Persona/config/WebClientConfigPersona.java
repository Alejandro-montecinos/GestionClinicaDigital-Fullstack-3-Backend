package com.ClinicaIntegral.Persona.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfigPersona {
    
    @Bean
    public WebClient comunaWebClient(){
        return WebClient.builder().baseUrl("http://localhost:2121/").build();
    }
}
