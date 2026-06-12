package com.clinica.integral.mensajeria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.clinica.integral.mensajeria.models.entities.Mensaje;
import com.clinica.integral.mensajeria.models.request.MensajeEditarRequest;
import com.clinica.integral.mensajeria.models.request.MensajeRequest;
import com.clinica.integral.mensajeria.repositories.MensajeRepository;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepo;

    public List<Mensaje> ObtenerMensaje(){
        return mensajeRepo.findAll();
    }

    public Mensaje enviarMensaje( MensajeRequest mensajeNuevo ){
        
        Mensaje mensaje = new Mensaje();
        mensaje.setContenido(mensajeNuevo.getContenido());

        return mensajeRepo.save(mensaje);

    }

    public Mensaje actualizarConvenioSalud( MensajeEditarRequest mensajeEditado, int idMen ){
        Mensaje mensajeExiste = mensajeRepo.findById(idMen).orElse(null);
        if (mensajeExiste == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Mensaje no encontrado.");
        }

        mensajeExiste.setContenido(mensajeEditado.getContenido());
        return mensajeRepo.save(mensajeExiste);

    }

    public String eliminarMensaje( int id_mensaje ){
        Mensaje mensajeExiste = mensajeRepo.findById(id_mensaje).orElse(null);
        if ( mensajeExiste == null ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mensaje no encontrado");
        }
        
        mensajeRepo.deleteById(id_mensaje);
        return "Mensaje eliminado";

    }

}
