package com.ClinicaIntegral.region.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ClinicaIntegral.region.model.entities.RegionModel;

@Repository
public interface RegionRepository extends JpaRepository<RegionModel,Integer> {
    
}
