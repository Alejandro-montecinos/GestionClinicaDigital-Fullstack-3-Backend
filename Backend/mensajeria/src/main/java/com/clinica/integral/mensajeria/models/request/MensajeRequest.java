package com.clinica.integral.mensajeria.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MensajeRequest {
    
    @NotBlank
    private String contenido;
}
