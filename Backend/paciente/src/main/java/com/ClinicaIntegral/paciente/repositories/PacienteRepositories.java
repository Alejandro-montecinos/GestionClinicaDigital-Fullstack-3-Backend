package com.ClinicaIntegral.paciente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ClinicaIntegral.paciente.model.entities.PacienteModel;

public interface PacienteRepositories extends JpaRepository<PacienteModel,Integer> {
    
}
