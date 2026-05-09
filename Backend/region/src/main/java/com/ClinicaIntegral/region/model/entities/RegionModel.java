package com.ClinicaIntegral.region.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "REGION")
public class RegionModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_region;

    @Column(nullable = false)
    private String nombre_region;

    @Column(nullable = false)
    private int pais_id_pais;
}
