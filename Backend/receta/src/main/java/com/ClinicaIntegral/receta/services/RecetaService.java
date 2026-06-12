package com.ClinicaIntegral.receta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ClinicaIntegral.receta.models.entities.Receta;
import com.ClinicaIntegral.receta.models.request.RecetaEditarRequest;
import com.ClinicaIntegral.receta.models.request.RecetaRequest;
import com.ClinicaIntegral.receta.repositories.RecetaRepository;

@Service
public class RecetaService {

    @Autowired
    private RecetaRepository recetaRepo;

    public List<Receta> ObtenerRecetas(){
        return recetaRepo.findAll();
    }

    public Receta agregarReceta( RecetaRequest recetaNueva ){
        
        Receta receta = new Receta();
        receta.setDescripcion(recetaNueva.getDescripcion());
        receta.setFecha_emision(recetaNueva.getFecha_emision());

        return recetaRepo.save(receta);

    }

    public Receta actualizarReceta( RecetaEditarRequest recetaEditada, int idRec ){
        Receta recetaExiste = recetaRepo.findById(idRec).orElse(null);
        if (recetaExiste == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Receta no encontrada.");
        }

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
