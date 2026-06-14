package com.example.ConsultaMedica.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class ActualizarConsultaMedica {


    @NotBlank
    private String fechaConsulta_ConsultaMedica;

    @NotBlank
    private String sintomas_ConsultaMedica;

    @NotBlank
    private String observaciones_ConsultaMedica;

    @NotBlank
    private String diagnostico_ConsultaMedica;

    @NotBlank
    private Integer medico_idMedico;
}
