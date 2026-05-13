package com.clinica.integral.especialidadMedica.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EspecialidadMedicaEditarRequest {
    @NotBlank(message = "El id de la especialidad medica no es opcional.")
    private int id_especialidad_medica;

    @NotBlank(message = "El nombre de la especialidad medica no es opcional.")
    private String nombre_especialidad_medica;


}
