package com.clinica.integral.especialidadMedica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.integral.especialidadMedica.models.entities.EspecialidadMedica;
import com.clinica.integral.especialidadMedica.models.request.EspecialidadMedicaRequest;
import com.clinica.integral.especialidadMedica.services.EspecialidadMedicaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RequestMapping("/especialidadMedica") //localhost:8085/especialidadMedica
@RestController
public class EspecialidadMedicaController {

    @Autowired
    private EspecialidadMedicaService especialidadMedicaService;

    @GetMapping("")
    public List<EspecialidadMedica> obtenerEspecialidades() {
        return especialidadMedicaService.ObtenerEspecialidades();
    }
    
    @PostMapping("")
    public EspecialidadMedica agregarEspecialidad(@RequestBody EspecialidadMedicaRequest especialidadNueva ){
        return especialidadMedicaService.agregarEspecialidad(especialidadNueva);
    }

    @PutMapping("")
    public EspecialidadMedica editarEspecialidad(@RequestBody EspecialidadMedicaRequest especialidadEditada ){

        return especialidadMedicaService.actualizarEspecialidad(especialidadEditada);

    }

    @DeleteMapping("/{id_especialidad_medica}")
    public String eliminarEspecialidad( @PathVariable int id_especialidad_medica ){
        return especialidadMedicaService.eliminarEspecialidad(id_especialidad_medica);
    }

}
