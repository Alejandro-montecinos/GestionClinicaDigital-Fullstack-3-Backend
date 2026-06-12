package com.ClinicaIntegral.paciente.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.ClinicaIntegral.paciente.model.dto.PersonaDto;
import com.ClinicaIntegral.paciente.model.entities.PacienteModel;
import com.ClinicaIntegral.paciente.model.request.ActualizarPaciente;
import com.ClinicaIntegral.paciente.model.request.AgregarPaciente;
import com.ClinicaIntegral.paciente.repositories.PacienteRepositories;

@Service
public class PacienteService {
    
    @Autowired
    private PacienteRepositories pacienteRepositories;

    @Autowired
    private WebClient webClient;

    public List<PacienteModel> obtenerTodosLosPacientes (){
        return pacienteRepositories.findAll();
    }


    public PacienteModel obtenerPacientePorId (Integer idPaciente){
        PacienteModel pam = pacienteRepositories.findById(idPaciente).orElse(null);
        if (pam == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Paciente no encontrado");
        }
        return pam;
    }


    public PacienteModel agregarPaciente (AgregarPaciente agregarPaciente){

        PersonaDto personaDto = null;

        try {
            personaDto = webClient.get()
            .uri("persona/{idP}",agregarPaciente.getPersona_idPersona())
            .retrieve()
            .bodyToMono(PersonaDto.class)
            .block();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
            "Error al obtener la Persona: " + e.getStatusText());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"Error de conexión con el servicio de Persona");
        }

        if (personaDto == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"DTO sin contenido");
        }

        if (personaDto.idPersona() != agregarPaciente.getPersona_idPersona()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Persona inválida");
        }



        PacienteModel model = new PacienteModel();
        
        model.setPersona_idPersona(agregarPaciente.getPersona_idPersona());
        model.setNombrePaciente(agregarPaciente.getNombrePaciente());
        model.setConvenio_id_convenio(agregarPaciente.getConvenio_id_convenio());
        return pacienteRepositories.save(model);
    }

    public String eliminarPaciete (Integer idPaciente){
        if (pacienteRepositories.existsById(idPaciente)) {
            pacienteRepositories.deleteById(idPaciente);
            return "Paciente eliminado correctamente";
        }else{
            return "Error al eliminar paciente";
        }
    }

    
    public PacienteModel actualizarPaciente (Integer idPaciente, ActualizarPaciente actualizarPaciente){
        PacienteModel pam = pacienteRepositories.findById(idPaciente).orElse(null);
        if (pam == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Paciente no encontrado");
        }


        PersonaDto personaDto = null;

        try {
            personaDto = webClient.get()
            .uri("persona/{idCom}",actualizarPaciente.getPersona_idPersona())
            .retrieve()
            .bodyToMono(PersonaDto.class)
            .block();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
            "Error al obtener la persona: " + e.getStatusText());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"Error de conexión con el servicio de persona");
        }

        if (personaDto == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"DTO sin contenido");
        }

        if (personaDto.idPersona() != actualizarPaciente.getPersona_idPersona()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "persona inválida");
        }

        
        pam.setPersona_idPersona(actualizarPaciente.getPersona_idPersona());
        pam.setNombrePaciente(actualizarPaciente.getNombrePaciente());
        pam.setConvenio_id_convenio(actualizarPaciente.getConvenio_id_convenio());
        
        return pacienteRepositories.save(pam);
    }

    










    

}
