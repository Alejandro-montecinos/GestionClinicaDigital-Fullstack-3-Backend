package com.ClinicaIntegral.Persona.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;


import com.ClinicaIntegral.Persona.models.dto.ComunaDto;
import com.ClinicaIntegral.Persona.models.entities.PersonaModel;
import com.ClinicaIntegral.Persona.models.request.ActualizarPersona;
import com.ClinicaIntegral.Persona.models.request.AgregarPersona;
import com.ClinicaIntegral.Persona.models.request.LoginPersonaRequest;
import com.ClinicaIntegral.Persona.repositories.PersonaRepositories;

@Service
public class PersonaService {
    
    @Autowired
    private PersonaRepositories personaRepositories;

    @Autowired
    private WebClient webClient;


    public List<PersonaModel> obtenerTodasLasPersonas(){
        return personaRepositories.findAll();
    }

    public PersonaModel buscarPersonaPorId (int id){
        PersonaModel personaM = personaRepositories.findById(id).orElse(null);
        if (personaM == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Persona no encontrada");
        }
        return personaM;
    }

    public PersonaModel agregarPersona (AgregarPersona nuevaP){
        
        ComunaDto comunaDto = null;
        

        try {
            comunaDto = webClient.get()
            .uri("comuna/{idCom}",nuevaP.getCOMUNA_id_comuna())
            .retrieve()
            .bodyToMono(ComunaDto.class)
            .block();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
            "Error al obtener la Comuna: " + e.getStatusText());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"Error de conexión con el servicio de comuna");
        }

        if (comunaDto == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"DTO sin contenido");
        }

        if (comunaDto.id_comuna() != nuevaP.getCOMUNA_id_comuna()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comuna inválida");
        }

        PersonaModel personaNueva = new PersonaModel();
        personaNueva.setRun(nuevaP.getRun());
        personaNueva.setNombre(nuevaP.getNombre());
        personaNueva.setApellido_paterno(nuevaP.getApellido_paterno());
        personaNueva.setApellido_materno(nuevaP.getApellido_materno());
        personaNueva.setTelefono(nuevaP.getTelefono());
        personaNueva.setCorreo(nuevaP.getCorreo());
        personaNueva.setContrasenia(nuevaP.getContrasenia());
        personaNueva.setFecha_nacimiento(nuevaP.getFecha_nacimiento());
        personaNueva.setDireccion(nuevaP.getDireccion());
        personaNueva.setCOMUNA_id_comuna(nuevaP.getCOMUNA_id_comuna());
        personaNueva.setROL_id_rol(nuevaP.getROL_id_rol());


        return personaRepositories.save(personaNueva);
    }

    public String eliminarPersona (int idPersona){
        if (personaRepositories.existsById(idPersona)) {
            personaRepositories.deleteById(idPersona);
            return "Persona eliminada correctamente";
        } else {
            return "Persona no encontrado";
        }
    }

    public PersonaModel actualizarPersona(int idPersona, ActualizarPersona nuevaP){
    PersonaModel personaModel = personaRepositories.findById(idPersona).orElse(null);

    if (personaModel == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Persona no encontrada");
    }

    personaModel.setRun(nuevaP.getRun());
    personaModel.setNombre(nuevaP.getNombre());
    personaModel.setApellido_paterno(nuevaP.getApellido_paterno());
    personaModel.setApellido_materno(nuevaP.getApellido_materno());
    personaModel.setTelefono(nuevaP.getTelefono());
    personaModel.setCorreo(nuevaP.getCorreo());
    personaModel.setContrasenia(nuevaP.getContrasenia());
    personaModel.setFecha_nacimiento(nuevaP.getFecha_nacimiento());
    personaModel.setDireccion(nuevaP.getDireccion());
    personaModel.setCOMUNA_id_comuna(nuevaP.getCOMUNA_id_comuna());
    personaModel.setROL_id_rol(nuevaP.getROL_id_rol());

    return personaRepositories.save(personaModel);
    }



    public PersonaModel loginPersona(LoginPersonaRequest request) {
    PersonaModel persona = personaRepositories.findByCorreo(request.getCorreo())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    if (!persona.getContrasenia().equals(request.getContrasenia())) {
        throw new RuntimeException("Correo o contraseña incorrectos");
    }

    return persona;
}



}
