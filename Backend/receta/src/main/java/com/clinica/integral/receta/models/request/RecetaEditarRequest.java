package com.clinica.integral.receta.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RecetaEditarRequest {
    @NotBlank(message = "El id de la receta no es opcional.")
    private int id_receta;

    @NotBlank(message = "La descripción de la receta no es opcional.")
    private String descripcion;

    @NotBlank(message = "La fecha de emisión de la receta no es opcional.")
    private String fecha_emision;

}
