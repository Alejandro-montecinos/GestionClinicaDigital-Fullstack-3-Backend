package com.ClinicaIntegral.comuna.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EditarComunaRequest {

    @NotBlank(message = "id_comuna tiene que ser obligatrio")
    private int id_comuna;

    @NotBlank(message = "nombre_comuna tiene que ser obligatrio")
    private String nombre_comuna;

    @NotBlank(message = "ciudad_id_ciudad tiene que ser obligatrio")
    private int ciudad_id_ciudad;

}