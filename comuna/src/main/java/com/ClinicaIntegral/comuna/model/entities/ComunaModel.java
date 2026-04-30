package com.ClinicaIntegral.comuna.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "COMUNA")
public class ComunaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_comuna;

    @Column(nullable = false)
    private String nombre_comuna;

    @Column(nullable = false)
    private int ciudad_id_ciudad;
}
