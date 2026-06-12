package com.ClinicaIntegral.administrativo.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ADMINISTRATIVO")
public class AdministrativoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdministrativo;

    @Column(nullable = false,unique = true)
    private String run;

    @Column(nullable = false)
    private String nombreAdministrativo;

    @Column(nullable = false)
    private int rol_id_rol;
}
