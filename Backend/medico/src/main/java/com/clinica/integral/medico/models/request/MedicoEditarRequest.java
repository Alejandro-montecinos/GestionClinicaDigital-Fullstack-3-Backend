package com.clinica.integral.medico.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MedicoEditarRequest {
    
    @NotBlank
    private String nombreMedico;
    
    @NotBlank
    private int persona_idPersona;

    @NotBlank
    private int cargoMedico_idCargoMedico;

    @NotBlank
    private int especialidadMedica_idEspecialidad;

}
