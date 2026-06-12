package com.ClinicaIntegral.paciente.model.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarPaciente {
    
    @NotBlank
    private String nombrePaciente;

    @NotBlank
    private int persona_idPersona;

    @NotBlank
    private int convenio_id_convenio;
}
