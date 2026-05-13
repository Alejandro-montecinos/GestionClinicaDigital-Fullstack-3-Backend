package com.ClinicaIntegral.pais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ClinicaIntegral.pais.models.entities.PaisModel;

@Repository
public interface PaisRepositori extends JpaRepository<PaisModel,Integer> {
    
}
