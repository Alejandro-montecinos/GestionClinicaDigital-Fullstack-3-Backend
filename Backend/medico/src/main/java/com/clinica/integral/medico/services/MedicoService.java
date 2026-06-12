package com.clinica.integral.medico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.clinica.integral.medico.models.dto.PersonaDTO;
import com.clinica.integral.medico.models.entities.Medico;
import com.clinica.integral.medico.models.request.MedicoRequest;
import com.clinica.integral.medico.repositories.MedicoRepository;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepo;

    @Autowired
    private WebClient webClient;





    public List<Medico> obtenerTodosLosMedicos(){
        return medicoRepo.findAll();
    }

    public Medico agregarMedico( MedicoRequest medicoNuevo ){

        PersonaDTO personaDTO = null;
        
        try {
            personaDTO = webClient.get()
            .uri("persona/{idP}",medicoNuevo.getPersona_idPersona())
            .retrieve()
            .bodyToMono(PersonaDTO.class)
            .block();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
            "Error al obtener la Persona: " + e.getStatusText());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"Error de conexión con el servicio de Persona");
        }

        if (personaDTO == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"DTO sin contenido");
        }

        if (personaDTO.idPersona() != medicoNuevo.getPersona_idPersona()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Persona inválida");
        }


        Medico medico = new Medico();

        medico.setNombreMedico(medicoNuevo.getNombreMedico());
        medico.setPersona_idPersona(medicoNuevo.getPersona_idPersona());
        medico.setCargoMedico_idCargoMedico(medicoNuevo.getCargoMedico_idCargoMedico());
        medico.setEspecialidadMedica_idEspecialidad(medicoNuevo.getEspecialidadMedica_idEspecialidad());

        return medicoRepo.save(medico);

    }

    public Medico actualizarMedico( MedicoRequest medicoActualizado, int idMedico ){
        Medico medicoExiste = medicoRepo.findById(idMedico).orElse(null);
        if (medicoExiste == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Médico no encontrado.");
        }

        PersonaDTO personaDTO = null;
        
        try {
            personaDTO = webClient.get()
            .uri("persona/{idP}",medicoActualizado.getPersona_idPersona())
            .retrieve()
            .bodyToMono(PersonaDTO.class)
            .block();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
            "Error al obtener la Persona: " + e.getStatusText());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"Error de conexión con el servicio de Persona");
        }

        if (personaDTO == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"DTO sin contenido");
        }

        if (personaDTO.idPersona() != medicoActualizado.getPersona_idPersona()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Persona inválida");
        }


        medicoExiste.setNombreMedico(medicoActualizado.getNombreMedico());
        medicoExiste.setPersona_idPersona(medicoActualizado.getPersona_idPersona());
        medicoExiste.setCargoMedico_idCargoMedico(medicoActualizado.getCargoMedico_idCargoMedico());
        medicoExiste.setEspecialidadMedica_idEspecialidad(medicoActualizado.getEspecialidadMedica_idEspecialidad());

        return medicoRepo.save(medicoExiste);

    }

    public Medico obtenerMedicoPorId(int idMedico){
        return medicoRepo.findById(idMedico).orElse(null);
    }

    public String eliminarMedico( int id_medico ){
        Medico medicoExiste = medicoRepo.findById(id_medico).orElse(null);
        if ( medicoExiste == null ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico no encontrado");
        }

        medicoRepo.deleteById(id_medico);
        return "Médico eliminado";

    }

}
