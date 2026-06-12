package com.ClinicaIntegral.administrativo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ClinicaIntegral.administrativo.models.entities.AdministrativoModel;
import com.ClinicaIntegral.administrativo.models.request.ActualizarAdministrativo;
import com.ClinicaIntegral.administrativo.models.request.AgregarAdministrativo;
import com.ClinicaIntegral.administrativo.repositories.AdministrativoRepositories;

@Service
public class AdministrativoServices {
    
    @Autowired
    private AdministrativoRepositories administrativoRepositories;

    
    public List<AdministrativoModel> obtenerTodosLosAdministrativos(){
        return administrativoRepositories.findAll();
    }

    public AdministrativoModel ObtenerAdministrativoPorId(int runAd){
        AdministrativoModel am = administrativoRepositories.findById(runAd).orElse(null);
        if (am == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Administrativo no encontra");
        }
        return am;
    }

    public AdministrativoModel guardarAdministrativo ( AgregarAdministrativo newAd){
        AdministrativoModel administrativoModel= new AdministrativoModel();

        administrativoModel.setRun(newAd.getRun());
        administrativoModel.setNombreAdministrativo(newAd.getNombreAdministrativo());
        administrativoModel.setRol_id_rol(newAd.getRol_id_rol());

        return administrativoRepositories.save(administrativoModel);

    }


    public String eliminarAdministrativo (int idadmin){
        if (administrativoRepositories.existsById(idadmin)) {
            administrativoRepositories.deleteById(idadmin);
            return "Administrativo eliminado";
        } else {
            return "Administrativo no encntrado";    
        }
    }


    public AdministrativoModel editarAdministrativo (int idAdmin, ActualizarAdministrativo newAd){
        AdministrativoModel am = administrativoRepositories.findById(idAdmin).orElse(null);
        if (am == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Administrativo no encontrada");
        }

        am.setRun(newAd.getRun());
        am.setNombreAdministrativo(newAd.getNombreAdministrativo());
        am.setRol_id_rol(newAd.getRol_id_rol());

        return administrativoRepositories.save(am);


    }

}
