package com.clinica.integral.receta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.integral.receta.models.entities.Receta;
import com.clinica.integral.receta.models.request.RecetaEditarRequest;
import com.clinica.integral.receta.models.request.RecetaRequest;
import com.clinica.integral.receta.services.RecetaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RequestMapping("/receta") //localhost:8082/receta
@RestController
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

    @PutMapping("")
    public Receta editarReceta(@RequestBody RecetaEditarRequest recetaEditada ){

        return recetaService.actualizarReceta(recetaEditada);

    }

    @DeleteMapping("/{id_receta}")
    public String eliminarReceta( @PathVariable int id_receta ){
        return recetaService.eliminarReceta(id_receta);
    }

}
