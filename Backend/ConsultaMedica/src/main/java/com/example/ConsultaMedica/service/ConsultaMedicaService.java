package com.example.ConsultaMedica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.example.ConsultaMedica.models.dto.MedicoDto;
import com.example.ConsultaMedica.models.entities.ConsultaMedica;
import com.example.ConsultaMedica.models.request.ActualizarConsultaMedica;
import com.example.ConsultaMedica.models.request.AgregarConsultaMedica;
import com.example.ConsultaMedica.repository.ConsultaMedicaRepository;


@Service
public class ConsultaMedicaService {

    @Autowired
    private ConsultaMedicaRepository consultaMedicaRepository;

    @Autowired
    private WebClient webClient;
        

    public List<ConsultaMedica> obtenerTodasLasConsultas (){
        return consultaMedicaRepository.findAll();
    }

    public ConsultaMedica obtenerTodasLasConsultasPorId (int idConsulta){
        ConsultaMedica consultaMedica = consultaMedicaRepository.findById(idConsulta).orElse(null);
        if (consultaMedica == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"consultaMedica  no encontrada");
        }

        return consultaMedica;
    }

    public ConsultaMedica guardarConsultaMedica (AgregarConsultaMedica agregarConsultaMedica){

        
        MedicoDto medicoDto = null;

        try {
            medicoDto = webClient.get()
            .uri("medico/{idMedico}", agregarConsultaMedica.getMedico_idMedico())
            .retrieve()
            .bodyToMono(MedicoDto.class)
            .block();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
            "Error al obtener la Medico: " + e.getStatusText());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"Error de conexión con el servicio de Medico");
        }

        if (medicoDto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medico no encontrado");
        }

        if (medicoDto.idMedico() != agregarConsultaMedica.getMedico_idMedico()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Medico inválida");
        }


        ConsultaMedica consultaMedica = new ConsultaMedica();
        consultaMedica.setDiagnostico_ConsultaMedica(agregarConsultaMedica.getDiagnostico_ConsultaMedica());
        consultaMedica.setFechaConsulta_ConsultaMedica(agregarConsultaMedica.getFechaConsulta_ConsultaMedica());
        consultaMedica.setSintomas_ConsultaMedica(agregarConsultaMedica.getSintomas_ConsultaMedica());
        consultaMedica.setObservaciones_ConsultaMedica(agregarConsultaMedica.getObservaciones_ConsultaMedica());
        consultaMedica.setMedico_idMedico(agregarConsultaMedica.getMedico_idMedico());

        return consultaMedicaRepository.save(consultaMedica);
    }

    public String eliminarConsultaMedica (int idConsulta){
        if (consultaMedicaRepository.existsById(idConsulta)) {
            consultaMedicaRepository.deleteById(idConsulta);
            return "ConsultaMedica eliminado ";
        } else {
            return "ConsultaMedica no eliminado";
        }
    }

    public ConsultaMedica editarConsultaMedica (int idConsulta, ActualizarConsultaMedica actualizarConsultaMedica){
        ConsultaMedica consultaMedica = consultaMedicaRepository.findById(idConsulta).orElse(null);
        if (consultaMedica == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"consultaMedica  no encontrada");
        }


               MedicoDto medicoDto = null;

        try {
            medicoDto = webClient.get()
            .uri("/medico/{idMedico}", actualizarConsultaMedica.getMedico_idMedico())
            .retrieve()
            .bodyToMono(MedicoDto.class)
            .block();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
            "Error al obtener la Medico: " + e.getStatusText());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"Error de conexión con el servicio de Medico");
        }

        if (medicoDto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medico no encontrado");
        }

        if (medicoDto.idMedico() != actualizarConsultaMedica.getMedico_idMedico()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Medico inválida");
        }


        consultaMedica.setDiagnostico_ConsultaMedica(actualizarConsultaMedica.getDiagnostico_ConsultaMedica());
        consultaMedica.setFechaConsulta_ConsultaMedica(actualizarConsultaMedica.getFechaConsulta_ConsultaMedica());
        consultaMedica.setSintomas_ConsultaMedica(actualizarConsultaMedica.getSintomas_ConsultaMedica());
        consultaMedica.setObservaciones_ConsultaMedica(actualizarConsultaMedica.getObservaciones_ConsultaMedica());
        consultaMedica.setMedico_idMedico(actualizarConsultaMedica.getMedico_idMedico());

        return consultaMedicaRepository.save(consultaMedica);

    }

}