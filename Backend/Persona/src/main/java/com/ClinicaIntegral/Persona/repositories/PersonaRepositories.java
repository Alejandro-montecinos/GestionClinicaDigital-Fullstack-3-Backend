package com.ClinicaIntegral.Persona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ClinicaIntegral.Persona.models.entities.PersonaModel;

public interface PersonaRepositories extends JpaRepository<PersonaModel,Integer> {


    
}
