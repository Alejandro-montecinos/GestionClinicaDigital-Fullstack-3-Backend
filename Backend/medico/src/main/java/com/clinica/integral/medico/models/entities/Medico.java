package com.clinica.integral.medico.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedico;

    @Column(nullable = false)
    private String nombreMedico;

    @Column(nullable = false)
    private int persona_idPersona;

    @Column(nullable = false)
    private int cargoMedico_idCargoMedico;

    @Column(nullable = false)
    private int especialidadMedica_idEspecialidad;




    
}