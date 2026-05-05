package com.ClinicaIntegral.HistorialClinico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ClinicaIntegral.HistorialClinico.models.entities.HistorialModel;

public interface HistorialRepositories extends JpaRepository<HistorialModel, Integer> {
    
}
