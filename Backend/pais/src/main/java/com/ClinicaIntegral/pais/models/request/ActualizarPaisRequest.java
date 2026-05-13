package com.ClinicaIntegral.pais.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarPaisRequest {
    @NotBlank
    private String nombrePais;
}
