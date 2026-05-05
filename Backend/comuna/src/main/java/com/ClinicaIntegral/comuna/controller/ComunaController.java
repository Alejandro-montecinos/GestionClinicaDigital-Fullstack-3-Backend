package com.ClinicaIntegral.comuna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClinicaIntegral.comuna.model.entities.ComunaModel;
import com.ClinicaIntegral.comuna.model.request.AgregarComunaRequest;
import com.ClinicaIntegral.comuna.model.request.EditarComunaRequest;
import com.ClinicaIntegral.comuna.service.ComunaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RequestMapping("comuna")
@RestController
public class ComunaController {
    
    @Autowired
    private ComunaService comunaService;

    @GetMapping("")
    public List<ComunaModel> obtenerTodasLasComunas() {
        return comunaService.obtenerTodasLasComunas();
    }

    @GetMapping("/{idCom}")
    public ComunaModel obtenerComunaPorId (@PathVariable int idCom) {
        return comunaService.obtenerComunaPorId(idCom);
    }


    @PostMapping("")
    public ComunaModel guardarComuna(@RequestBody AgregarComunaRequest agregarCom) {
        return comunaService.agregarComuna(agregarCom);
    }
    
    
    @PutMapping("/{idCom}")
    public ComunaModel editarComuna(@RequestBody EditarComunaRequest editarCom,@PathVariable int idCom) {
        return comunaService.editarComuna(editarCom, idCom);
    }


    @DeleteMapping("/{idCom}")
    public String eliminarComuna (@PathVariable int idCom){
        return comunaService.eliminarComuna(idCom);
    }


}
