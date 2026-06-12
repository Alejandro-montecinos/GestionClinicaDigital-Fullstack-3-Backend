package com.clinica.integral.mensajeria.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MensajeEditarRequest {

    @NotBlank(message = "El contenido del mensaje no es opcional.")
    private String contenido;

}
