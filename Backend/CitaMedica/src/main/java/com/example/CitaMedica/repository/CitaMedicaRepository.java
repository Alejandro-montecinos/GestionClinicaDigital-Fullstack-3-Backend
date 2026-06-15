package com.example.CitaMedica.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.CitaMedica.models.entities.CitaMedica;

@Repository
public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Integer> {

    @Query(value = "SELECT * FROM cita_medica", nativeQuery = true)
    List<CitaMedica> obtenerTodasLasCitasNativas();
}