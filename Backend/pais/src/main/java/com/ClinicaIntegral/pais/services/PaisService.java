package com.ClinicaIntegral.pais.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ClinicaIntegral.pais.models.entities.PaisModel;
import com.ClinicaIntegral.pais.models.request.ActualizarPaisRequest;
import com.ClinicaIntegral.pais.models.request.AgregarPaisRequest;
import com.ClinicaIntegral.pais.repositories.PaisRepositori;

@Service
public class PaisService {
    
    @Autowired
    private PaisRepositori paisRepositori;

    public List<PaisModel> obtenerTodosLosPaises(){
        return paisRepositori.findAll();
    }

    public PaisModel obtenerPAisPorId (int idPais){
        PaisModel paisModel = paisRepositori.findById(idPais).orElse(null);
        if (paisModel == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Persona no encontrada");
        }
        return paisModel;
    }

    public PaisModel guardarPais (AgregarPaisRequest paisReq){
        PaisModel paisModel = new PaisModel();
        paisModel.setNombrePais(paisReq.getNombrePais());
        return paisRepositori.save(paisModel);
    }

    public String eliminarPais (int idPais){
        if (paisRepositori.existsById(idPais)) {
            paisRepositori.deleteById(idPais);
            return "Pais eliminada correctamente";
        } else {
            return "Pais no encontrado";
        }
    }


    public PaisModel editarPais(ActualizarPaisRequest paisRec, int idPais){
        PaisModel paisModel = paisRepositori.findById(idPais).orElse(null);
        if (paisModel == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Persona no encontrada");
        }

        paisModel.setNombrePais(paisRec.getNombrePais());
        return paisRepositori.save(paisModel);

    }



}
