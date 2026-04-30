package com.ClinicaIntegral.comuna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ClinicaIntegral.comuna.model.entities.ComunaModel;

@Repository
public interface ComunaRepositories extends JpaRepository<ComunaModel,Integer> {
    
}
