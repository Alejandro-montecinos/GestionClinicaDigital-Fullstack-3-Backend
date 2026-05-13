package com.example.ConsultaMedica.models.entities;

import jakarta.persistence.Column;
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
    private int idConsulta;

    @Column(nullable = false)
    private String fechaConsulta_ConsultaMedica;

    @Column(nullable = false)
    private String sintomas_ConsultaMedica;

    @Column(nullable = false)
    private String observaciones_ConsultaMedica;

    @Column(nullable = false)
    private String diagnostico_ConsultaMedica;

    @Column(nullable = false)
    private int pacienteId;

    @Column(nullable = false)
    private int medicoId;
}