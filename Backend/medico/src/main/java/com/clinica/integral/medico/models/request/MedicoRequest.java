package com.clinica.integral.medico.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MedicoRequest {

    @NotBlank
    private String nombreMedico;

    @NotBlank
    private int persona_idPersona;

    @NotBlank
    private int cargoMedico_idCargoMedico;

    @NotBlank
    private int rol_idRol;

    @NotBlank
    private int especialidadMedica_idEspecialidad;


    
}
