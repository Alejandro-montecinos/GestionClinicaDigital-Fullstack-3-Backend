package com.ClinicaIntegral.region.controller;

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

import com.ClinicaIntegral.region.model.entities.RegionModel;
import com.ClinicaIntegral.region.model.request.ActualizarRegionRequest;
import com.ClinicaIntegral.region.model.request.AgregarRegionRequest;
import com.ClinicaIntegral.region.services.RegionService;

@RequestMapping("region")
@RestController
@CrossOrigin(origins = "*")
public class RegionController {
    
    @Autowired
    private RegionService regionService;

    @GetMapping("")
    public List<RegionModel> obtenerTodasLasRegiones(){
        return regionService.obtenerTodasLasRegiones();
    }

    @GetMapping("/{idRegion}")
    public RegionModel obtenerRegionPorId(@PathVariable int idRegion){
        return regionService.obtenerRegionPorId(idRegion);
    }

    @PostMapping()
    public RegionModel agregarRegion(@RequestBody AgregarRegionRequest agregarR){
        return regionService.agregarRegion(agregarR);
    }

    @PutMapping("/{idRegion}")
        public RegionModel actualizarRegion(@PathVariable int idRegion,@RequestBody ActualizarRegionRequest actualizarR){
    return regionService.editarRegion(actualizarR, idRegion);
}

    @DeleteMapping("/{idRegion}")
    public String eliminarRegion(@PathVariable int idRegion){
        return regionService.eliminarRegion(idRegion);
    }

}
