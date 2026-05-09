package com.ClinicaIntegral.region.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarRegionRequest {
    

    @NotBlank
    private String nombre_region;

    @NotBlank
    private int pais_id_pais;
}
