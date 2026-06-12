package com.clinica.integral.especialidadMedica.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EspecialidadMedicaRequest {
    @NotBlank
    private int id_especialidad_medica;

    @NotBlank
    private String nombre_especialidad_medica;

}
