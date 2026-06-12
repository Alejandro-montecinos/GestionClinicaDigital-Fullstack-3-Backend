package com.clinica.integral.medico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.integral.medico.models.entities.Medico;
import com.clinica.integral.medico.models.request.MedicoRequest;
import com.clinica.integral.medico.services.MedicoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RequestMapping("/medico") //localhost:8087/medico
@RestController
@CrossOrigin(origins = "*")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping("")
    public List<Medico> obtenerMedicos() {
        return medicoService.obtenerTodosLosMedicos();
    }

    @PostMapping("")
    public Medico agregarMedico(@RequestBody MedicoRequest medicoNuevo ){
        return medicoService.agregarMedico(medicoNuevo);
    }
    
    @PutMapping("/{idMedico}")
    public Medico actualizarMedico(@RequestBody MedicoRequest medicoEditado,@PathVariable int idMedico){
        return medicoService.actualizarMedico(medicoEditado,idMedico);
    }

    @GetMapping("/{idMedico}")
    public Medico obtenerMedicoPorId(@PathVariable int idMedico){
        return medicoService.obtenerMedicoPorId(idMedico);
    }
    

    @DeleteMapping("/{idMedico}")
    public String eliminarMedico( @PathVariable int idMedico ){
        return medicoService.eliminarMedico(idMedico);
    }

}
