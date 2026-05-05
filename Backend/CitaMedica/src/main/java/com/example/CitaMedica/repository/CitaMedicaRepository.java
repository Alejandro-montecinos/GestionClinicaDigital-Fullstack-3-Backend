package com.example.CitaMedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CitaMedica.model.CitaMedica;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Integer> {
    
}
