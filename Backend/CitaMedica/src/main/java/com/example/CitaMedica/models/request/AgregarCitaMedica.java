package com.example.CitaMedica.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarCitaMedica {
    
    @NotBlank
    private int id_cita;

    @NotBlank
    private String fecha_cita;

    @NotBlank
    private String hora_agendada_cita;

    @NotBlank
    private String motivo_cita;

    @NotBlank
    private String estado_cita;

    @NotBlank
    private int paciente_id_paciente;

    @NotBlank
    private int medico_id_medico;
}
