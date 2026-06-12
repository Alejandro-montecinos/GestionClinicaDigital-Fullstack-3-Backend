package com.clinica.integral.medico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.clinica.integral.medico.models.entities.Medico;
import com.clinica.integral.medico.models.request.MedicoRequest;
import com.clinica.integral.medico.repositories.MedicoRepository;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepo;

/*     @Autowired
    private WebClient personaWebClient; */

    /* public Medico agregarMedico(MedicoRequest crearMedico){
        PersonaDto personaDto = null;

        try {
            personaDto = personaWebClient.get()
            .uri("persona/{run}", crearMedico.getPersonaRun())
            .retrieve()
            .bodyToMono(PersonaDto.class)
            .block();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ENDPOINT ---> Error al obtener la persona: " + e.getMessage());
        }

        if (personaDto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró la persona con RUN: " + crearMedico.getPersonaRun());
        }

        Medico medico = new Medico();

        medico.setPersona_run(crearMedico.getPersonaRun());
        medico.setNombre(crearMedico.getNombre());
        medico.setApellido_paterno(crearMedico.getApellido_paterno());
        medico.setApellido_materno(crearMedico.getApellido_materno());
        medico.setFecha_nacimiento(crearMedico.getFecha_nacimiento());
        medico.setTelefono(crearMedico.getTelefono());
        medico.setCorreo(crearMedico.getCorreo());
        medico.setDireccion(crearMedico.getDireccion());
        medico.setCOMUNA_id_comuna(crearMedico.getCOMUNA_id_comuna());
        medico.setROL_id_rol(crearMedico.getROL_id_rol());

        return medicoRepo.save(medico);

    } */

    public List<Medico> obtenerTodosLosMedicos(){
        return medicoRepo.findAll();
    }

    public Medico agregarMedico( MedicoRequest medicoNuevo ){
        
        Medico medico = new Medico();

        medico.setNombreMedico(medicoNuevo.getNombreMedico());
        medico.setPersona_idPersona(medicoNuevo.getPersona_idPersona());
        medico.setCargoMedico_idCargoMedico(medicoNuevo.getCargoMedico_idCargoMedico());
        medico.setEspecialidadMedica_idEspecialidad(medicoNuevo.getEspecialidadMedica_idEspecialidad());
        medico.setRol_idRol(medicoNuevo.getRol_idRol());

        return medicoRepo.save(medico);

    }

    public Medico actualizarMedico( MedicoRequest medicoActualizado, int idMedico ){
        Medico medicoExiste = medicoRepo.findById(idMedico).orElse(null);
        if (medicoExiste == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Médico no encontrado.");
        }

        medicoExiste.setNombreMedico(medicoActualizado.getNombreMedico());
        medicoExiste.setPersona_idPersona(medicoActualizado.getPersona_idPersona());
        medicoExiste.setCargoMedico_idCargoMedico(medicoActualizado.getCargoMedico_idCargoMedico());
        medicoExiste.setEspecialidadMedica_idEspecialidad(medicoActualizado.getEspecialidadMedica_idEspecialidad());
        medicoExiste.setRol_idRol(medicoActualizado.getRol_idRol());

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
