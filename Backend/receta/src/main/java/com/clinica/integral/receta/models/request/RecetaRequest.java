package com.clinica.integral.receta.models.request;

import lombok.Data;

@Data
public class RecetaRequest {
    private int id_receta;
    private String descripcion;
    private String fecha_emision;
}
