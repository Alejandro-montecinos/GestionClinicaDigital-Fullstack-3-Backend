package com.ClinicaIntegral.ciudad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ClinicaIntegral.ciudad.models.entities.CiudadModel;
import com.ClinicaIntegral.ciudad.models.request.ActualizarCiudadRequest;
import com.ClinicaIntegral.ciudad.models.request.AgregarCiudadRequest;
import com.ClinicaIntegral.ciudad.repositories.CiudadRepositories;

@Service
public class CiudadService {
    
    @Autowired
    private CiudadRepositories ciudadRepositories;

    public List<CiudadModel> obtenerTodasLasCiudades(){
        return ciudadRepositories.findAll();
    }

    public CiudadModel obtenerCiudadPorId(int id){
        CiudadModel ciudadM = ciudadRepositories.findById(id).orElse(null);
        if (ciudadM == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Ciudad no encontrado");
        }
        return ciudadM;
    }


    public CiudadModel agregarCiudad (AgregarCiudadRequest ciuReq){

        CiudadModel ciudadN = new CiudadModel();

        ciudadN.setNombreCiudad(ciuReq.getNombreCiudad());
        ciudadN.setRegion_id_region(ciuReq.getRegion_id_region());

        return ciudadRepositories.save(ciudadN);

    }

    public String eliminarCiudad (int idPersona){
        if (ciudadRepositories.existsById(idPersona)) {
            ciudadRepositories.deleteById(idPersona);
            return "Ciudad eliminada correctamente";
        } else {
            return "Ciudad no encontrado";
        }
    }


    public CiudadModel editarCiudad(int idCiudad,ActualizarCiudadRequest ciuReq ){
        CiudadModel ciudadM = ciudadRepositories.findById(idCiudad).orElse(null);
        if (ciudadM == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Ciudad no encontrado");
        }
       
        ciudadM.setNombreCiudad(ciuReq.getNombreCiudad());
        ciudadM.setRegion_id_region(ciuReq.getRegion_id_region());
        
        ciudadRepositories.save(ciudadM);

        return ciudadM;



    }












}
