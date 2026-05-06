package com.ClinicaIntegral.ciudad.models.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CIUDAD")
public class CiudadModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCiudad;

    @Column(nullable = false)
    private String nombreCiudad;

    @Column(nullable = false)
    private int region_id_region;



}
