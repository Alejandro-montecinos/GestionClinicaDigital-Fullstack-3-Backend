package com.clinica.integral.convenio_salud.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "nombre_convenio_salud")
public class ConvenioSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_convenio_salud;

    @Column(nullable = false)
    private String nombre_convenio_salud;

}
