package com.clinica.integral.receta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.integral.receta.models.entities.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Integer>{

}
