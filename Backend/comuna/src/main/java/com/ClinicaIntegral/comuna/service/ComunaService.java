package com.ClinicaIntegral.comuna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ClinicaIntegral.comuna.model.entities.ComunaModel;
import com.ClinicaIntegral.comuna.model.request.AgregarComunaRequest;
import com.ClinicaIntegral.comuna.model.request.EditarComunaRequest;
import com.ClinicaIntegral.comuna.repositories.ComunaRepositories;

@Service
public class ComunaService {
    
    @Autowired
    private ComunaRepositories comunaRepositories;


    public List<ComunaModel> obtenerTodasLasComunas (){
        return comunaRepositories.findAll();
    }

    public ComunaModel obtenerComunaPorId(int idCom){
        
        ComunaModel comunamodel =comunaRepositories.findById(idCom).orElse(null);
        if (comunamodel == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Comuna no encontrada");
        }
        return comunamodel;
    
    }

    public ComunaModel agregarComuna(AgregarComunaRequest comunaReq){
        ComunaModel comunaModel = new ComunaModel();

        comunaModel.setNombre_comuna(comunaReq.getNombre_comuna());
        comunaModel.setCiudad_id_ciudad(comunaReq.getCiudad_id_ciudad());

        comunaRepositories.save(comunaModel);
        return comunaModel;

    }

    public String eliminarComuna (int idCom){
        ComunaModel comunamodel =comunaRepositories.findById(idCom).orElse(null);
        if (comunamodel != null) {
            comunaRepositories.deleteById(idCom);
            return "Se elimino la Comuna";
        
        }else{
            return "No se encontro la Comuna";
        }
    }

    public ComunaModel editarComuna(EditarComunaRequest comunaEdit, int id){

        ComunaModel comunaModel =comunaRepositories.findById(id).orElse(null);
        System.out.println(comunaEdit.getId_comuna());
        if (comunaModel == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Comuna no encontrada");
        }
        comunaModel.setNombre_comuna(comunaEdit.getNombre_comuna());
        comunaModel.setCiudad_id_ciudad(comunaEdit.getCiudad_id_ciudad());
        comunaRepositories.save(comunaModel);
        return comunaModel;
    }










}
