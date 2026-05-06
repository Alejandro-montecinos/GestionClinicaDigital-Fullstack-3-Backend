package com.ClinicaIntegral.ciudad.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarCiudadRequest {
    
    @NotBlank
    private String nombreCiudad;

    @NotBlank
    private int region_id_region;

}
