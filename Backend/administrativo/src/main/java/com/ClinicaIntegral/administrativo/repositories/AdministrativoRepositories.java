package com.ClinicaIntegral.administrativo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ClinicaIntegral.administrativo.models.entities.AdministrativoModel;


public interface AdministrativoRepositories extends JpaRepository<AdministrativoModel,Integer> {
    
}
