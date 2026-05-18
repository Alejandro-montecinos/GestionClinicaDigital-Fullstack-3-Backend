package com.ClinicaIntegral.Persona.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginPersonaRequest {
    @NotBlank
    private String correo;
    
    @NotBlank
    private String contrasenia;
}
