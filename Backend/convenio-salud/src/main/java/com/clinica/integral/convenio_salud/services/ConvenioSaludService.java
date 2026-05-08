package com.clinica.integral.convenio_salud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.clinica.integral.convenio_salud.models.entities.ConvenioSalud;
import com.clinica.integral.convenio_salud.models.request.ConvenioSaludActualizarRequest;
import com.clinica.integral.convenio_salud.models.request.ConvenioSaludRequest;
import com.clinica.integral.convenio_salud.repositories.ConvenioSaludRepository;

@Service
public class ConvenioSaludService {

    @Autowired
    private ConvenioSaludRepository convenioRepo;

    public List<ConvenioSalud> obtenerConvenios(){
        return convenioRepo.findAll();
    }

    public ConvenioSalud agregarConvenioSalud( ConvenioSaludRequest convenioNuevo ){
        
        ConvenioSalud convenio = new ConvenioSalud();
        convenio.setId_convenio_salud(convenioNuevo.getId_convenio_salud());
        convenio.setNombre_convenio_salud(convenioNuevo.getNombre_convenio_salud());

        return convenioRepo.save(convenio);

    }

    public ConvenioSalud actualizarConvenioSalud( ConvenioSaludActualizarRequest convenioEditado ){
        ConvenioSalud convenioExiste = convenioRepo.findById(convenioEditado.getId_convenio_salud()).orElse(null);
        if (convenioExiste == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Convenio no encontrado.");
        }

        convenioExiste.setId_convenio_salud(convenioEditado.getId_convenio_salud());
        convenioExiste.setNombre_convenio_salud(convenioEditado.getNombre_convenio_salud());
        return convenioRepo.save(convenioExiste);

    }

    public String eliminarConvenioSalud( int id_convenio_salud ){
        ConvenioSalud convenioExiste = convenioRepo.findById(id_convenio_salud).orElse(null);
        if ( convenioExiste == null ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Convenio no encontrado");
        }
        
        convenioRepo.deleteById(id_convenio_salud);
        return "Convenio eliminado";

    }

}
