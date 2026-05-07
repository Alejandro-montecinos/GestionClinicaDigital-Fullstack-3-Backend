package com.example.Tratamiento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Tratamiento.models.entities.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Integer> {

    List<Tratamiento> findByConsultaId(Integer consultaId);
}