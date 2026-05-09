package com.ClinicaIntegral.region.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarRegionRequest {

    @NotBlank
    private String nombre_region;

    @NotBlank
    private int pais_id_pais;

}
