package com.example.CitaMedica.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CitaMedica.models.entities.CitaMedica;
import com.example.CitaMedica.repository.CitaMedicaRepository;

@Service
public class CitaMedicaService {
    
    @Autowired
    private CitaMedicaRepository citaMedicaRepository;
    
    public List<CitaMedica> obtenerTodos(){
        return citaMedicaRepository.obtenerTodasLasCitasNativas();
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
        
        existente.setFechaCita(citaMedica.getFechaCita());
        existente.setHoraAgendadaCita(citaMedica.getHoraAgendadaCita());
        existente.setMotivoCita(citaMedica.getMotivoCita());
        existente.setEstadoCita(citaMedica.getEstadoCita());
        existente.setPacienteIdPaciente(citaMedica.getPacienteIdPaciente());
        existente.setMedicoIdMedico(citaMedica.getMedicoIdMedico());

        return citaMedicaRepository.save(existente);
    }

    public void eliminar(int id) {
        citaMedicaRepository.deleteById(id);
    }
}