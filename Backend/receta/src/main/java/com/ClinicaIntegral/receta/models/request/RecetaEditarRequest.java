package com.ClinicaIntegral.receta.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RecetaEditarRequest {

    @NotBlank(message = "La descripción de la receta no es opcional.")
    private String descripcion;

    @NotBlank(message = "La fecha de emisión de la receta no es opcional.")
    private String fecha_emision;

}
