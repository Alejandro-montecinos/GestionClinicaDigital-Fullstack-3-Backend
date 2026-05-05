package com.example.Tratamiento.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tratamiento")
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTratamiento;
    
    @Column(nullable = false)
    private String descripcion_Tratamiento;

    @Column(nullable = false)
    private String indicaciones_Tratamiento;
    
    @Column(nullable = false)
    private Integer consultaId;
}