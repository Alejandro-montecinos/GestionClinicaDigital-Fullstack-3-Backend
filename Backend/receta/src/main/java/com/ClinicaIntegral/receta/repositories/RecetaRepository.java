package com.ClinicaIntegral.receta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ClinicaIntegral.receta.models.entities.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Integer>{

}