package com.example.CitaMedica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CitaMedica.model.CitaMedica;
import com.example.CitaMedica.repository.CitaMedicaRepository;

@Service
public class CitaMedicaService {
    @Autowired
    private CitaMedicaRepository citaMedicaRepository;
    
    public List<CitaMedica> obtenerTodos(){
        return citaMedicaRepository.findAll();
    }

    public CitaMedica obtenerId(int id) {
        return citaMedicaRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("Cita médica no encontrada con id: " + id));      
    }

    public CitaMedica guardar(CitaMedica citaMedica){
        return citaMedicaRepository.save(citaMedica);
    }

    public CitaMedica actualizar(int id, CitaMedica citaMedica) {
        CitaMedica existente = obtenerId(id);
        existente.setFecha_cita(citaMedica.getFecha_cita());
        existente.setHora_agendada(citaMedica.getHora_agendada());
        existente.setMotivo_cita(citaMedica.getMotivo_cita());
        existente.setEstado_cita(citaMedica.getEstado_cita());
        existente.setPaciente_id_paciente(citaMedica.getPaciente_id_paciente());
        existente.setMedico_id_medico(citaMedica.getMedico_id_medico());

        return citaMedicaRepository.save(existente);
    }

    public void eliminar(int id) {
        citaMedicaRepository.deleteById(id);
    }

}
