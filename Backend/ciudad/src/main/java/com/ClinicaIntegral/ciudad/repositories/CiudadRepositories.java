package com.ClinicaIntegral.ciudad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ClinicaIntegral.ciudad.models.entities.CiudadModel;

@Repository
public interface CiudadRepositories extends JpaRepository<CiudadModel,Integer> {

    
}
