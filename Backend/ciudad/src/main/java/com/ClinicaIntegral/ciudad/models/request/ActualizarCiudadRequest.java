package com.ClinicaIntegral.ciudad.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarCiudadRequest {
 
    
    @NotBlank
    private String nombreCiudad;

    @NotBlank
    private int region_id_region;

}
