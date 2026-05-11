package com.clinica.integral.mensajeria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.integral.mensajeria.models.entities.Mensaje;

public interface MensajeRepository extends JpaRepository<Mensaje, Integer>{

}
