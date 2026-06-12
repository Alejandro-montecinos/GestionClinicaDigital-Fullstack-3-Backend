package com.ClinicaIntegral.administrativo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClinicaIntegral.administrativo.models.entities.AdministrativoModel;
import com.ClinicaIntegral.administrativo.models.request.ActualizarAdministrativo;
import com.ClinicaIntegral.administrativo.models.request.AgregarAdministrativo;
import com.ClinicaIntegral.administrativo.services.AdministrativoServices;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RequestMapping("administrativo")
@RestController
@CrossOrigin(origins = "*")
public class AdministrativoController {

    @Autowired
    private AdministrativoServices administrativoServices;

    @GetMapping("")
    public List<AdministrativoModel> obtenerAdministrativo () {
        return administrativoServices.obtenerTodosLosAdministrativos();
    }

    @GetMapping("/{idAdmin}")
    public AdministrativoModel obtenerAdministrativoPorId (@PathVariable int idAdmin) {
        return administrativoServices.ObtenerAdministrativoPorId(idAdmin);
    }

    @PostMapping()
    public AdministrativoModel guardarAdministrativo (@RequestBody AgregarAdministrativo agregarAdministrativo) {
        return administrativoServices.guardarAdministrativo(agregarAdministrativo);
    }

    @PutMapping("/{idAdmin}")
    public AdministrativoModel editarAdministrativo (@PathVariable int idAdmin, @RequestBody ActualizarAdministrativo actualizarAdministrativo) {
        return administrativoServices.editarAdministrativo(idAdmin, actualizarAdministrativo);
    }

    @DeleteMapping("/{idAdmin}")
    public String eliminarAdministrativo (@PathVariable int idAdmin){
        return administrativoServices.eliminarAdministrativo(idAdmin);
    }


    


    

}
