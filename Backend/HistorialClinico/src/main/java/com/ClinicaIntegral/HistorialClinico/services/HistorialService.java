package com.ClinicaIntegral.HistorialClinico.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ClinicaIntegral.HistorialClinico.models.entities.HistorialModel;
import com.ClinicaIntegral.HistorialClinico.models.request.ActualizarHistorial;
import com.ClinicaIntegral.HistorialClinico.models.request.AgregarHistorial;
import com.ClinicaIntegral.HistorialClinico.repositories.HistorialRepositories;

@Service
public class HistorialService {

    @Autowired
    private HistorialRepositories historialRepositories;

    public List<HistorialModel> obtenerTodosLosHistoriales(){
        return historialRepositories.findAll();
    }


    public HistorialModel buscarHistorialPorId (int id){
        HistorialModel historialm = historialRepositories.findById(id).orElse(null);
        if (historialm == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Historial no encontrado");
        }
        return historialm;
    }


    public HistorialModel agragarHistorial (AgregarHistorial nuevaH){
        HistorialModel historialnuevo = new HistorialModel();
        historialnuevo.setAlergias(nuevaH.getAlergias());
        historialnuevo.setAntecedentes_medicos(nuevaH.getAntecedentes_medicos());
        historialnuevo.setId_historial_clinico(nuevaH.getId_historial_clinico());
        historialnuevo.setObservaciones_generales(nuevaH.getObservaciones_generales());

        return historialRepositories.save(historialnuevo);
    }

    public String eliminarHistorial (int idHistorial){
        if (historialRepositories.existsById(idHistorial)) {
            historialRepositories.deleteById(idHistorial);
            return "Historial eliminada correctamente";
        } else {
            return "Historial no encontrado";
        }
    }

    public HistorialModel actualizarHistorial (ActualizarHistorial nuevaH){
        HistorialModel historialModel = historialRepositories.findById(nuevaH.getId_historial_clinico()).orElse(null);
        if (historialModel == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Historial no encontrado");
        } else {
             historialModel.setAlergias(nuevaH.getAlergias());
        historialModel.setAntecedentes_medicos(nuevaH.getAntecedentes_medicos());
        historialModel.setId_historial_clinico(nuevaH.getId_historial_clinico());
        historialModel.setObservaciones_generales(nuevaH.getObservaciones_generales());

        return historialRepositories.save(historialModel);
        }
    }

   



    
}
