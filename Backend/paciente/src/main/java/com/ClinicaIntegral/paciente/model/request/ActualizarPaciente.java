package com.ClinicaIntegral.paciente.model.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarPaciente {
    
    @NotBlank
    private String nombrePaciente;

    @NotBlank
    private int perosna_idPersona;

    @NotBlank
    private int convenio_id_convenio;
}
