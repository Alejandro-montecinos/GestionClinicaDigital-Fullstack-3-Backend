package com.example.ConsultaMedica.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarConsultaMedica {
    
    
    @NotBlank
    private int idPersona;
    
    @NotBlank
    private Integer idConsulta;

    @NotBlank
    private String fechaConsulta_ConsultaMedica;

    @NotBlank
    private String sintomas_ConsultaMedica;

    @NotBlank
    private String observaciones_ConsultaMedica;

    @NotBlank
    private String diagnostico_ConsultaMedica;

    @NotBlank
    private Integer pacienteId;

    @NotBlank
    private Integer medicoId;

}
