package com.ClinicaIntegral.paciente.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ClinicaIntegral.paciente.model.entities.PacienteModel;
import com.ClinicaIntegral.paciente.model.request.ActualizarPaciente;
import com.ClinicaIntegral.paciente.model.request.AgregarPaciente;
import com.ClinicaIntegral.paciente.repositories.PacienteRepositories;

@Service
public class PacienteService {
    
    @Autowired
    private PacienteRepositories pacienteRepositories;

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
        PacienteModel model = new PacienteModel();
        
        model.setPerosna_idPersona(agregarPaciente.getPerosna_idPersona());
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
        
        pam.setPerosna_idPersona(actualizarPaciente.getPerosna_idPersona());
        pam.setNombrePaciente(actualizarPaciente.getNombrePaciente());
        pam.setConvenio_id_convenio(actualizarPaciente.getConvenio_id_convenio());
        
        return pacienteRepositories.save(pam);
    }

    










    

}
