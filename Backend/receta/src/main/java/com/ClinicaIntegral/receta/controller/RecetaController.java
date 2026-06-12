package com.ClinicaIntegral.receta.controller;

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

import com.ClinicaIntegral.receta.models.entities.Receta;
import com.ClinicaIntegral.receta.models.request.RecetaEditarRequest;
import com.ClinicaIntegral.receta.models.request.RecetaRequest;
import com.ClinicaIntegral.receta.services.RecetaService;

@RequestMapping("/receta") //localhost:8082/receta
@RestController
@CrossOrigin(origins = "*")
public class RecetaController {

    @Autowired
    private RecetaService recetaService;

    @GetMapping("")
    public List<Receta> obtenerRecetas() {
        return recetaService.ObtenerRecetas();
    }
    
    @PostMapping("")
    public Receta enviarReceta(@RequestBody RecetaRequest recetaNueva ){
        return recetaService.agregarReceta(recetaNueva);
    }

    @PutMapping("/{idRec}")
    public Receta editarReceta(@RequestBody RecetaEditarRequest recetaEditada, @PathVariable int idRec ){

        return recetaService.actualizarReceta(recetaEditada, idRec);

    }

    @DeleteMapping("/{id_receta}")
    public String eliminarReceta( @PathVariable int id_receta ){
        return recetaService.eliminarReceta(id_receta);
    }

}

