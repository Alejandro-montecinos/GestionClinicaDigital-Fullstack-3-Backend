package com.ClinicaIntegral.pais.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClinicaIntegral.pais.models.entities.PaisModel;
import com.ClinicaIntegral.pais.models.request.ActualizarPaisRequest;
import com.ClinicaIntegral.pais.models.request.AgregarPaisRequest;
import com.ClinicaIntegral.pais.services.PaisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Pais")
public class PaisController {
    
    @Autowired
    private PaisService paisService;


    @GetMapping()
    public List<PaisModel> obtenerTodosLosPaises () {
        return paisService.obtenerTodosLosPaises();
    }

    @GetMapping("/{idPais}")
    public PaisModel obtenerPaisPorId (@PathVariable int idPais) {
        return paisService.obtenerPAisPorId(idPais);
    }

    @PostMapping()
    public PaisModel agregarPais (@RequestBody AgregarPaisRequest agregarPaisRequest) {
        return paisService.guardarPais(agregarPaisRequest);
    }

    @PutMapping("/{idPais}")
    public PaisModel editarPais (@PathVariable int idPais, @RequestBody ActualizarPaisRequest actualizarPaisRequest) {
        return paisService.editarPais(actualizarPaisRequest, idPais);
    }

    @DeleteMapping("/{idPais}")
    public String eliminarPais (@PathVariable int idPais){
        return paisService.eliminarPais(idPais);
    }

    
    
    
    

}
