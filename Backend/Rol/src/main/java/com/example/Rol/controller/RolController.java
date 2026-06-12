package com.example.Rol.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Rol.models.entities.Rol;
import com.example.Rol.models.request.ActualizarRol;
import com.example.Rol.models.request.AgregarRol;
import com.example.Rol.service.RolService;

@RequestMapping("rol")
@RestController
@CrossOrigin(origins = "*")
public class RolController {
    
@Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> obtenerTodosLosRoles() {
        return rolService.obtenerTodosLosRoles();
    }

    @PostMapping
    public Rol guardarRol (@RequestBody AgregarRol agregarRol) {
        return rolService.guardarRol(agregarRol);
    }

    @GetMapping("/{idRol}")
    public Rol obtenerRolPorId (@PathVariable int idRol) {
        return rolService.obtenerRolPorId(idRol);
    }

    @PutMapping("/{idRol}")
    public Rol actualizarRol(@PathVariable int idRol, @RequestBody ActualizarRol actualizarRol) {
        return rolService.actualizarRol(idRol, actualizarRol);
    }

    @DeleteMapping("/{idRol}")
    public String eliminarRol (@PathVariable int idRol) {
        return rolService.eliminarRol(idRol); 
    }
}
