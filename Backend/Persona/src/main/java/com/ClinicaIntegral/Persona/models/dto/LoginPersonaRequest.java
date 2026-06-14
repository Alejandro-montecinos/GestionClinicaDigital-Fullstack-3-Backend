package com.ClinicaIntegral.Persona.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginPersonaRequest {
    @NotBlank
    private String correo;
    
    @NotBlank
    private String contrasenia;
}






