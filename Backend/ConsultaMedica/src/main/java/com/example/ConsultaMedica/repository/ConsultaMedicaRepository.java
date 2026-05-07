package com.example.ConsultaMedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ConsultaMedica.models.entities.ConsultaMedica;

@Repository
public interface ConsultaMedicaRepository extends JpaRepository<ConsultaMedica, Integer> {
}