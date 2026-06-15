package com.example.CitaMedica.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CitaMedica.models.entities.CitaMedica;
import com.example.CitaMedica.service.CitaMedicaService;

@RestController
@RequestMapping("/cita_medica")
@CrossOrigin(origins = "*")
public class CitaMedicaController {

    @Autowired
    private CitaMedicaService citaMedicaService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public List<Map<String, Object>> listar() {
        // Esto consulta la tabla usando JDBC directo, ignorando por completo los modelos de Hibernate
        return jdbcTemplate.queryForList("SELECT * FROM cita_medica");
    }
    
    @GetMapping("/{id}")
    public CitaMedica obtenerPorId(@PathVariable int id) {
        return citaMedicaService.obtenerId(id);
    }

    @PostMapping
    public CitaMedica crear (@RequestBody CitaMedica citaMedica) {
        return citaMedicaService.guardar(citaMedica);
    }

    @PutMapping("/{id}")
    public CitaMedica actualizar(@PathVariable int id, @RequestBody CitaMedica citaMedica) {
        return citaMedicaService.actualizar(id, citaMedica);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        citaMedicaService.eliminar(id);
    }
}