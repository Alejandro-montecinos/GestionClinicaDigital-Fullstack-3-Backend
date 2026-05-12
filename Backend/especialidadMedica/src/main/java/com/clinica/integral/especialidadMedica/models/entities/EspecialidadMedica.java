package com.clinica.integral.especialidadMedica.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "especialidad_medica")
public class EspecialidadMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_especialidad_medica;

    @Column(nullable = false)
    private String nombre_especialidad_medica;

}
