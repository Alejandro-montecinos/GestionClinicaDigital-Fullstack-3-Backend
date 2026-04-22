package com.ClinicaIntegral.HistorialClinico.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "HISTORIAL_CLINICO")
public class HistorialModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_historial_clinico;

    @Column(nullable = false)
    private String antecedentes_medicos;

    @Column(nullable = false)
    private String alergias;

    @Column(nullable = false)
    private String observaciones_generales;

    @Column(nullable = false)
    private int paciente_id_paciente;

}
