package com.example.ConsultaMedica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "consulta_medica")
public class ConsultaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsulta;

    private String fechaConsulta_ConsultaMedica;

    private String sintomas_ConsultaMedica;

    private String observaciones_ConsultaMedica;

    private String diagnostico_ConsultaMedica;

    private Integer pacienteId;

    private Integer medicoId;
}