package com.clinica.integral.receta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.clinica.integral.receta.models.entities.Receta;
import com.clinica.integral.receta.models.request.RecetaEditarRequest;
import com.clinica.integral.receta.models.request.RecetaRequest;
import com.clinica.integral.receta.repositories.RecetaRepository;

@Service
public class RecetaService {

    @Autowired
    private RecetaRepository recetaRepo;

    public List<Receta> ObtenerRecetas(){
        return recetaRepo.findAll();
    }

    public Receta agregarReceta( RecetaRequest recetaNueva ){
        
        Receta receta = new Receta();
        receta.setId_receta(recetaNueva.getId_receta());
        receta.setDescripcion(recetaNueva.getDescripcion());
        receta.setFecha_emision(recetaNueva.getFecha_emision());

        return recetaRepo.save(receta);

    }

    public Receta actualizarReceta( RecetaEditarRequest recetaEditada ){
        Receta recetaExiste = recetaRepo.findById(recetaEditada.getId_receta()).orElse(null);
        if (recetaExiste == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Receta no encontrada.");
        }

        recetaExiste.setId_receta(recetaEditada.getId_receta());
        recetaExiste.setDescripcion(recetaEditada.getDescripcion());
        recetaExiste.setFecha_emision(recetaEditada.getFecha_emision());
        return recetaRepo.save(recetaExiste);

    }

    public String eliminarReceta( int id_receta ){
        Receta recetaExiste = recetaRepo.findById(id_receta).orElse(null);
        if ( recetaExiste == null ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Receta no encontrada");
        }
        
        recetaRepo.deleteById(id_receta);
        return "Receta eliminada";

    }

}
