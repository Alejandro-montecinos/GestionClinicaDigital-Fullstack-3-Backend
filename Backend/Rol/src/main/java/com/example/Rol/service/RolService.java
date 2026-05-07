package com.example.Rol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Rol.models.entities.Rol;
import com.example.Rol.repository.RolRepository;

@Service
public class RolService {
	
    @Autowired
    private RolRepository repository;

    public List<Rol> listar() {
        return repository.findAll();
    }

    public Rol guardar(Rol r) {
        return repository.save(r);
    }

    public Optional<Rol> buscarPorConsulta(Integer consultaId) {
        return repository.findById(consultaId);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public Rol actualizar(Integer id, Rol nuevo) {
        return repository.findById(id).map(r -> {
            r.setNombre_rol(nuevo.getNombre_rol());
            r.setDescripcion_rol(nuevo.getDescripcion_rol());
            return repository.save(r);
        }).orElse(null);
    }
}