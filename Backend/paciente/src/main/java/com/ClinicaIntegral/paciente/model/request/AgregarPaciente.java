package com.ClinicaIntegral.paciente.model.request;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarPaciente {
    
    @NotBlank
    private String nombrePaciente;

    @NotBlank
    private int perosna_idPersona;

    @NotBlank
    private int convenio_id_convenio;

}
