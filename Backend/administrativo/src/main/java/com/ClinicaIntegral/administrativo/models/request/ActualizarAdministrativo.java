package com.ClinicaIntegral.administrativo.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarAdministrativo {
    
    @NotBlank
    private String run;
    
    @NotBlank
    private String nombreAdministrativo;
    
    @NotBlank
    private int rol_id_rol;

}
