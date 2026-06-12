package com.clinica.integral.mensajeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.integral.mensajeria.models.entities.Mensaje;
import com.clinica.integral.mensajeria.models.request.MensajeEditarRequest;
import com.clinica.integral.mensajeria.models.request.MensajeRequest;
import com.clinica.integral.mensajeria.services.MensajeService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RequestMapping("/mensajes") //localhost:8081/mensajes
@RestController
@CrossOrigin(origins = "*")
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    @GetMapping("")
    public List<Mensaje> obtenerMensajes() {
        return mensajeService.ObtenerMensaje();
    }
    
    @PostMapping("")
    public Mensaje enviarMensaje(@RequestBody MensajeRequest mensajeNuevo ){
        return mensajeService.enviarMensaje(mensajeNuevo);
    }

    @PutMapping("/{idMen}")
    public Mensaje editarMensaje(@RequestBody MensajeEditarRequest mensajeEditado, @PathVariable int idMen ){

        return mensajeService.actualizarConvenioSalud(mensajeEditado, idMen);

    }

    @DeleteMapping("/{id_mensaje}")
    public String eliminarMensaje( @PathVariable int id_mensaje ){
        return mensajeService.eliminarMensaje(id_mensaje);
    }

}
