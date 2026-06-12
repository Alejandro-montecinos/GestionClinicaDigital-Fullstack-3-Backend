package com.ClinicaIntegral.ciudad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClinicaIntegral.ciudad.models.entities.CiudadModel;
import com.ClinicaIntegral.ciudad.models.request.ActualizarCiudadRequest;
import com.ClinicaIntegral.ciudad.models.request.AgregarCiudadRequest;
import com.ClinicaIntegral.ciudad.services.CiudadService;

@RestController
@RequestMapping("ciudad")
@CrossOrigin(origins = "*")
public class CiudadController {
    
    @Autowired
    private CiudadService ciudadService;


    @GetMapping("")
    public List<CiudadModel> obtenerTodasLasCiudades(){
        return ciudadService.obtenerTodasLasCiudades();
    }

    @GetMapping("/{idCiudad}")
    public CiudadModel obtenerCiudadSegunId(@PathVariable int idCiudad){
        return ciudadService.obtenerCiudadPorId(idCiudad);
    }

    @PostMapping("")
    public CiudadModel agregarCiudad (@RequestBody AgregarCiudadRequest ciuReq){
        return ciudadService.agregarCiudad(ciuReq);
    }

    @PutMapping("/{idCiudad}")
    public CiudadModel actualizarCiudad (@RequestBody ActualizarCiudadRequest ciuReq,@PathVariable int idCiudad){
        return ciudadService.editarCiudad(idCiudad, ciuReq);
    }

    @DeleteMapping("/{idCiudad}")
    public String eliminarCiudad (@PathVariable int idCiudad){
        return ciudadService.eliminarCiudad(idCiudad);
    }

}
