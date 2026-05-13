package com.example.Tratamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.example.Tratamiento.models.dto.ConsultaMedicaDto;
import com.example.Tratamiento.models.entities.Tratamiento;
import com.example.Tratamiento.repository.TratamientoRepository;

@Service
public class TratamientoService {
    
    @Autowired
    private TratamientoRepository repository;

    @Autowired
    private WebClient consultaMedicaWebClient;


    public List<Tratamiento> listar(){
        return repository.findAll();
    }

    public Tratamiento buscarPorConsulta (Integer consultaId){
        Tratamiento tratamiento = repository.findById(consultaId).orElse(null);

        if (tratamiento == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Tratamiento no encontrado"
            );
        }

        return tratamiento;
    }

    public Tratamiento guardar (Tratamiento nuevoT){
        
        ConsultaMedicaDto consultaDto = null;
        

        try {

            consultaDto = consultaMedicaWebClient.get()
            .uri("consultas/consulta/{idCon}", nuevoT.getConsulta_medica_id_consulta())
            .retrieve()
            .bodyToMono(ConsultaMedicaDto.class)
            .block();

        } catch (WebClientResponseException e) {

            throw new ResponseStatusException(
                HttpStatus.valueOf(e.getStatusCode().value()),
                "Error al obtener la Consulta Médica: " + e.getStatusText()
            );

        } catch (Exception e) {

            throw new ResponseStatusException(
                HttpStatus.SERVICE_UNAVAILABLE,
                "Error de conexión con el servicio de Consulta Médica"
            );
        }

        if (consultaDto == null) {

            throw new ResponseStatusException(
                HttpStatus.NO_CONTENT,
                "DTO sin contenido"
            );
        }

        if (consultaDto.idConsulta() != nuevoT.getConsulta_medica_id_consulta()) {

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Consulta Médica inválida"
            );
        }

        Tratamiento tratamientoNuevo = new Tratamiento();

        tratamientoNuevo.setDescripcion_Tratamiento(
            nuevoT.getDescripcion_Tratamiento()
        );

        tratamientoNuevo.setIndicaciones_Tratamiento(
            nuevoT.getIndicaciones_Tratamiento()
        );

        tratamientoNuevo.setConsulta_medica_id_consulta(
            nuevoT.getConsulta_medica_id_consulta()
        );

        return repository.save(tratamientoNuevo);
    }

    public String eliminar (Integer id){

        if (repository.existsById(id)) {

            repository.deleteById(id);
            return "Tratamiento eliminado correctamente";

        } else {

            return "Tratamiento no encontrado";
        }
    }

    public Tratamiento actualizar(Integer id, Tratamiento nuevoT){

        Tratamiento tratamiento = repository.findById(id).orElse(null);

        if (tratamiento == null) {

            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Tratamiento no encontrado"
            );
        }

        tratamiento.setDescripcion_Tratamiento(
            nuevoT.getDescripcion_Tratamiento()
        );

        tratamiento.setIndicaciones_Tratamiento(
            nuevoT.getIndicaciones_Tratamiento()
        );

        tratamiento.setConsulta_medica_id_consulta(
            nuevoT.getConsulta_medica_id_consulta()
        );

        return repository.save(tratamiento);
    }

}