package com.example.Tratamiento.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarTratamiento {
    @NotBlank
    private Integer idTratamiento;
    @NotBlank
    private String descripcion_Tratamiento;
    @NotBlank
    private String indicaciones_Tratamiento;
    @NotBlank
    private Integer consultaId;
}
