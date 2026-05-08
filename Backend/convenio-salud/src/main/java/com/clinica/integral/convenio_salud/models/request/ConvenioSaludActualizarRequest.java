package com.clinica.integral.convenio_salud.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ConvenioSaludActualizarRequest {
    @NotBlank(message = "El id del convenio no es opcional.")
    private int id_convenio_salud;

    @NotBlank(message = "El nombre del convenio no es opçional.")
    private String nombre_convenio_salud;

}
