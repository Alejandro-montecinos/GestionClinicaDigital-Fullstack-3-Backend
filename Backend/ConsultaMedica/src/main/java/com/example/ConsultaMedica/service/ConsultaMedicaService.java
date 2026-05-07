package com.example.ConsultaMedica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ConsultaMedica.models.entities.ConsultaMedica;
import com.example.ConsultaMedica.repository.ConsultaMedicaRepository;

@Service
public class ConsultaMedicaService {

    @Autowired
    private ConsultaMedicaRepository repository;

    public List<ConsultaMedica> listar() {
        return repository.findAll();
    }

    public ConsultaMedica guardar(ConsultaMedica consulta) {
        return repository.save(consulta);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public ConsultaMedica actualizar(Integer id, ConsultaMedica nueva) {
        return repository.findById(id).map(c -> {
            c.setFechaConsulta_ConsultaMedica(nueva.getFechaConsulta_ConsultaMedica());
            c.setSintomas_ConsultaMedica(nueva.getSintomas_ConsultaMedica());
            c.setObservaciones_ConsultaMedica(nueva.getObservaciones_ConsultaMedica());
            c.setDiagnostico_ConsultaMedica(nueva.getDiagnostico_ConsultaMedica());
            c.setPacienteId(nueva.getPacienteId());
            c.setMedicoId(nueva.getMedicoId());
            return repository.save(c);
        }).orElse(null);
    }
}