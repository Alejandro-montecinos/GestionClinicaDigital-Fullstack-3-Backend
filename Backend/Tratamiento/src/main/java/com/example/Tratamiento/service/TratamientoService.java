package com.example.Tratamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tratamiento.models.entities.Tratamiento;
import com.example.Tratamiento.repository.TratamientoRepository;

@Service
public class TratamientoService {

    @Autowired
    private TratamientoRepository repository;

    public List<Tratamiento> listar() {
        return repository.findAll();
    }

    public Tratamiento guardar(Tratamiento t) {
        return repository.save(t);
    }

    public List<Tratamiento> buscarPorConsulta(Integer consultaId) {
        return repository.findByConsultaId(consultaId);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public Tratamiento actualizar(Integer id, Tratamiento nuevo) {
        return repository.findById(id).map(t -> {
            t.setDescripcion_Tratamiento(nuevo.getDescripcion_Tratamiento());
            t.setIndicaciones_Tratamiento(nuevo.getIndicaciones_Tratamiento());
            t.setConsultaId(nuevo.getConsultaId());
            return repository.save(t);
        }).orElse(null);
    }
}