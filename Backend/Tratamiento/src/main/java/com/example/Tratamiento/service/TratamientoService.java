package com.example.Tratamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Tratamiento buscarPorConsulta(Integer consultaId) {
        Tratamiento tratamiento = repository.findById(consultaId).orElse(null);
        if (tratamiento == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND," Tratamiento no encontrado");
        
            
        }
        return tratamiento;
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public Tratamiento actualizar(Integer id, Tratamiento nuevo) {
        return repository.findById(id).map(t -> {
            t.setDescripcion_Tratamiento(nuevo.getDescripcion_Tratamiento());
            t.setIndicaciones_Tratamiento(nuevo.getIndicaciones_Tratamiento());
            t.setConsulta_medica_id_consulta(nuevo.getConsulta_medica_id_consulta());
            return repository.save(t);
        }).orElse(null);
    }
}