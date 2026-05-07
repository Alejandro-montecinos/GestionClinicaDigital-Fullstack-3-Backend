package com.example.CitaMedica.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cita_medica")
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id_cita;

    @Column(nullable = false)
     private String fecha_cita;

    @Column(nullable = false)
     private String hora_agendada_cita;

    @Column(nullable = false)
     private String motivo_cita;

    @Column(nullable = false)
     private String estado_cita;

    @Column(nullable = false)
     private int paciente_id_paciente;

    @Column(nullable = false)
     private int medico_id_medico;

}
