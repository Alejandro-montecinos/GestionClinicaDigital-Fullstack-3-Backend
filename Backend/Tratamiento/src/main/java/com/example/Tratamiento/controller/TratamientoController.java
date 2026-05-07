package com.example.Tratamiento.controller;

import java.util.List;

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

import com.example.Tratamiento.models.entities.Tratamiento;
import com.example.Tratamiento.service.TratamientoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tratamiento")
public class TratamientoController {

    @Autowired
    private TratamientoService service;

    @GetMapping
    public List<Tratamiento> listar() {
        return service.listar();
    }

    @PostMapping
    public Tratamiento guardar(@RequestBody Tratamiento t) {
        return service.guardar(t);
    }

    @GetMapping("/consulta/{id}")
    public List<Tratamiento> porConsulta(@PathVariable Integer id) {
        return service.buscarPorConsulta(id);
    }

    @PutMapping("/{id}")
    public Tratamiento actualizar(@PathVariable Integer id, @RequestBody Tratamiento t) {
        return service.actualizar(id, t);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}