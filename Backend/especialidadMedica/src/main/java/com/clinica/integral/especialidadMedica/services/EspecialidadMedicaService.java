package com.clinica.integral.especialidadMedica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.clinica.integral.especialidadMedica.models.entities.EspecialidadMedica;
import com.clinica.integral.especialidadMedica.models.request.EspecialidadMedicaRequest;
import com.clinica.integral.especialidadMedica.repositories.EspecialidadMedicaRepository;


@Service
public class EspecialidadMedicaService {

    @Autowired
    private EspecialidadMedicaRepository especialidadRepo;

    public List<EspecialidadMedica> ObtenerEspecialidades(){
        return especialidadRepo.findAll();
    }

    public EspecialidadMedica agregarEspecialidad( EspecialidadMedicaRequest especialidadNueva ){
        
        EspecialidadMedica especialidad = new EspecialidadMedica();
        especialidad.setNombre_especialidad_medica(especialidadNueva.getNombre_especialidad_medica());

        return especialidadRepo.save(especialidad);

    }

    public EspecialidadMedica actualizarEspecialidad( EspecialidadMedicaRequest especialidadEditada, int idEspe ){
        EspecialidadMedica especialidadExiste = especialidadRepo.findById(idEspe).orElse(null);
        if (especialidadExiste == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Especialidad no encontrada.");
        }
        
        especialidadExiste.setNombre_especialidad_medica(especialidadEditada.getNombre_especialidad_medica());
        return especialidadRepo.save(especialidadExiste);

    }

    public String eliminarEspecialidad( int id_especialidad_medica ){
        EspecialidadMedica especialidadExiste = especialidadRepo.findById(id_especialidad_medica).orElse(null);
        if ( especialidadExiste == null ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidad no encontrada");
        }
        
        especialidadRepo.deleteById(id_especialidad_medica);
        return "Especialidad eliminada";

    }

}
