package com.clinica.integral.convenio_salud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.integral.convenio_salud.models.entities.ConvenioSalud;
import com.clinica.integral.convenio_salud.models.request.ConvenioSaludActualizarRequest;
import com.clinica.integral.convenio_salud.models.request.ConvenioSaludRequest;
import com.clinica.integral.convenio_salud.services.ConvenioSaludService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RequestMapping("/convenio_salud") //localhost:8080/convenio_salud
@RestController
@CrossOrigin(origins = "*")
public class ConvenioSaludController {

    @Autowired
    private ConvenioSaludService convenioService;

    @GetMapping("")
    public List<ConvenioSalud> obtenerConvenios() {
        return convenioService.obtenerConvenios();
    }
    
    @PostMapping("")
    public ConvenioSalud agregarConvenioSalud(@RequestBody ConvenioSaludRequest convenioNuevo ){
        return convenioService.agregarConvenioSalud(convenioNuevo);
    }

    @PutMapping("/{idCon}")
    public ConvenioSalud actualizarConvenioSalud(@PathVariable int idCon,@RequestBody ConvenioSaludActualizarRequest convenioEditado ){

        return convenioService.actualizarConvenioSalud(idCon,convenioEditado);

    }

    @DeleteMapping("/{idCon}")
    public String eliminarConvenioSalud( @PathVariable int idCon ){
        return convenioService.eliminarConvenioSalud(idCon);
    }

}
