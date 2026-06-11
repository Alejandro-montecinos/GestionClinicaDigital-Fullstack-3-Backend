package com.ClinicaIntegral.paciente.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarPaciente {
    
    @NotBlank
    private String run;

    @NotBlank
    private int idPaciente;

    @NotBlank
    private int convenio_id_convenio;
}
