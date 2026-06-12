package com.ClinicaIntegral.receta.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RecetaRequest {
    @NotBlank
    private String descripcion;

    @NotBlank
    private String fecha_emision;
}