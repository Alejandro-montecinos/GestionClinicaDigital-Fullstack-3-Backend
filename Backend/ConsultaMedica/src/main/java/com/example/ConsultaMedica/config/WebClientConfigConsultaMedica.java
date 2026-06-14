package com.example.ConsultaMedica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfigConsultaMedica {
    
    @Bean
    public WebClient medicoWebClient(){
        return WebClient.builder().baseUrl("http://localhost:8087/").build();
    }

}
