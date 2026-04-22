package com.ClinicaIntegral.HistorialClinico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClinicaIntegral.HistorialClinico.models.entities.HistorialModel;
import com.ClinicaIntegral.HistorialClinico.models.request.ActualizarHistorial;
import com.ClinicaIntegral.HistorialClinico.models.request.AgregarHistorial;
import com.ClinicaIntegral.HistorialClinico.services.HistorialService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RequestMapping("historial")
@RestController
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @GetMapping("")
    public List<HistorialModel> obtenerTodosLosHistoriales() {
        return historialService.obtenerTodosLosHistoriales();
    }

    @GetMapping("/{idHistorial}")
    public HistorialModel obtenerHistorialPorId(@PathVariable int idHistorial) {
        return historialService.buscarHistorialPorId(idHistorial);
    }

    @PostMapping("")
    public HistorialModel agregarHistorial(@RequestBody AgregarHistorial hitom) {
        return historialService.agragarHistorial(hitom);
    }

    @PutMapping("/{idHistorial}")
    public HistorialModel actualizarMarca(@RequestBody ActualizarHistorial nuevaH) {
        return historialService.actualizarHistorial(nuevaH);
    }

    @DeleteMapping("/{idHistorial}")
    public String eliminarHistorial (@PathVariable int idHistorial){
        return historialService.eliminarHistorial(idHistorial);
    }

    
    
    
    
}
