package com.ClinicaIntegral.region.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ClinicaIntegral.region.model.entities.RegionModel;
import com.ClinicaIntegral.region.model.request.ActualizarRegionRequest;
import com.ClinicaIntegral.region.model.request.AgregarRegionRequest;
import com.ClinicaIntegral.region.repositories.RegionRepository;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<RegionModel> obtenerTodasLasRegiones (){
        return regionRepository.findAll(); 
    }

    public RegionModel obtenerRegionPorId (int id){
    
        RegionModel regionModel = regionRepository.findById(id).orElse(null);
        if (regionModel == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Region no encontrada");
        }
        return regionModel; 
            
    }


    public RegionModel agregarRegion(AgregarRegionRequest regionReq){
        
        RegionModel regionnueva = new RegionModel();

        regionnueva.setNombre_region(regionReq.getNombre_region());
        regionnueva.setPais_id_pais(regionReq.getPais_id_pais());

        return regionRepository.save(regionnueva);

    }


    public RegionModel editarRegion (ActualizarRegionRequest regionReq, int id){
        RegionModel regionModel = regionRepository.findById(id).orElse(null);
        if (regionModel == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Region no encontrada");
        } 
        
        regionModel.setNombre_region(regionReq.getNombre_region());
        regionModel.setPais_id_pais(regionReq.getPais_id_pais());

        return regionRepository.save(regionModel);
        
    }

    public String eliminarRegion (int id){
        
        if (regionRepository.existsById(id)){
            regionRepository.deleteById( id);
            return "Region Eliminada";
        } else {
            return "Region no encontrada";
        }
    }

    

    
}