package com.clinica.integral.medico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.integral.medico.models.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer>{

}
