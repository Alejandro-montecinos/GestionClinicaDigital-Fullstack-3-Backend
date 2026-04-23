package com.ClinicaIntegral.Persona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClinicaIntegral.Persona.models.entities.PersonaModel;
import com.ClinicaIntegral.Persona.models.request.ActualizarPersona;
import com.ClinicaIntegral.Persona.models.request.AgregarPersona;
import com.ClinicaIntegral.Persona.services.PersonaService;

@RequestMapping("persona")
@RestController
public class PersonaController {
    
    @Autowired
    private PersonaService personaService;

    @GetMapping("")
    public List<PersonaModel> obtenerTodasLasPersonas(){
        return personaService.obtenerTodasLasPersonas();
    }

    @GetMapping("/{idPersona}")
    public PersonaModel obtenerPersonaPorId(@PathVariable int idPersona){
        return personaService.buscarPersonaPorId(idPersona);
    }

    @PostMapping()
    public PersonaModel agregarPersona(@RequestBody AgregarPersona agregarP){
        return personaService.agregarPersona(agregarP);
    }

    @PutMapping("/{idPersona}")
public PersonaModel actualizarPersona(
        @PathVariable int idPersona,
        @RequestBody ActualizarPersona actualizarP){

    return personaService.actualizarPersona(idPersona, actualizarP);
}

    @DeleteMapping("/{idPersona}")
    public String eliminarPersona(@PathVariable int idPersona){
        return personaService.eliminarPersona(idPersona);
    }



}
