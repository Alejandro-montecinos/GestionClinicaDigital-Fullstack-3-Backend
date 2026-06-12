package com.example.Rol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Rol.models.entities.Rol;
import com.example.Rol.models.request.ActualizarRol;
import com.example.Rol.models.request.AgregarRol;
import com.example.Rol.repository.RolRepository;

@Service
public class RolService {
	
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerTodosLosRoles () {
        return rolRepository.findAll();
    }

    public Rol obtenerRolPorId(int idrol) {
        Rol rol = rolRepository.findById(idrol).orElse(null);
        if (rol == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Persona no encontrada");
        }       
        return rol;
    }
    
    
    public Rol guardarRol (AgregarRol agregarRol) {
        Rol rol = new Rol();
        rol.setNombre_rol(agregarRol.getNombre_rol());
        rol.setDescripcion_rol(agregarRol.getDescripcion_rol());

        return rolRepository.save(rol);
    }

    

    public String eliminarRol (int idRol) {
        if (rolRepository.existsById(idRol)) {
            rolRepository.deleteById(idRol);
            return "Rol eliminado ";
        } else {
            return "Error al eliminar Rol";
        }
    }

    public Rol actualizarRol(int idRol, ActualizarRol actualizarRol) {
        Rol rol = rolRepository.findById(idRol).orElse(null);
        if (rol == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Persona no encontrada");
        }
        rol.setNombre_rol(actualizarRol.getNombre_rol());
        rol.setDescripcion_rol(actualizarRol.getDescripcion_rol());
        return rolRepository.save(rol);

    }
        
}