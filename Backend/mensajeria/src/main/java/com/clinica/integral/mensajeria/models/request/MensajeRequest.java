package com.clinica.integral.mensajeria.models.request;

import lombok.Data;

@Data
public class MensajeRequest {
    private int id_mensaje;
    private String contenido;
}
