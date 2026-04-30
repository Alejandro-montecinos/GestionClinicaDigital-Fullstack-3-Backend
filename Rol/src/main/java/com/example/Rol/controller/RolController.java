package com.example.Rol.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Rol.model.Rol;
import com.example.Rol.service.RolService;

@RequestMapping("rol")
@RestController
public class RolController {
    
@Autowired
    private RolService service;

    @GetMapping
    public List<Rol> listar() {
        return service.listar();
    }

    @PostMapping
    public Rol guardar(@RequestBody Rol r) {
        return service.guardar(r);
    }

    @GetMapping("/consulta/{id}")
    public Optional<Rol> porConsulta(@PathVariable Integer id) {
        return service.buscarPorConsulta(id);
    }

    @PutMapping("/{id}")
    public Rol actualizar(@PathVariable Integer id, @RequestBody Rol r) {
        return service.actualizar(id, r);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
