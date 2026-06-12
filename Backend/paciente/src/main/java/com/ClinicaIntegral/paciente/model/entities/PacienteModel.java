package com.ClinicaIntegral.paciente.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PACIENTE")
public class PacienteModel {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int idPaciente;

    @Column(nullable = false)
    private String nombrePaciente;

    @Column(nullable = false)
    private int persona_idPersona;

    @Column(nullable = false)
    private int convenio_id_convenio;



    

}
