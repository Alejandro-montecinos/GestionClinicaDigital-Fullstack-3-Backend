package com.ClinicaIntegral.HistorialClinico.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarHistorial {
    
    @NotBlank
    private int id_historial_clinico;
    @NotBlank
    private String antecedentes_medicos;
    @NotBlank
    private String alergias;
    @NotBlank
    private String observaciones_generales;
    @NotBlank
    private int paciente_id_paciente;
}
