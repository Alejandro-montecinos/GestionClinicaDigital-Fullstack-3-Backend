package com.ClinicaIntegral.paciente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClinicaIntegral.paciente.model.entities.PacienteModel;
import com.ClinicaIntegral.paciente.model.request.ActualizarPaciente;
import com.ClinicaIntegral.paciente.model.request.AgregarPaciente;
import com.ClinicaIntegral.paciente.services.PacienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@CrossOrigin(origins = "*")
@RequestMapping("paciente")
@RestController
public class PacienteController {
    
    @Autowired
    private PacienteService pacienteService;


    @GetMapping("")
    public List<PacienteModel> obtenerTodosLosPacientes () {
        return pacienteService.obtenerTodosLosPacientes();
    }

    @GetMapping("/{run}")
    public PacienteModel obtenerTodosLosPacientesPorId (@PathVariable Integer run) {
        return pacienteService.obtenerPacientePorId(run);
    }

    @PostMapping()
    public PacienteModel agregarPaciente (@RequestBody AgregarPaciente agregarPaciente) {
        return pacienteService.agregarPaciente(agregarPaciente);
    }

    @PutMapping("/{run}")
    public PacienteModel actualizarPaciente(@PathVariable Integer run, @RequestBody ActualizarPaciente actualizarPaciente) {
        return pacienteService.actualizarPaciente(run, actualizarPaciente);
    }


    @DeleteMapping("/{run}")
    public String eliminarPaciente (@PathVariable Integer run){
        return pacienteService.eliminarPaciete(run);
    }
    
    
}
