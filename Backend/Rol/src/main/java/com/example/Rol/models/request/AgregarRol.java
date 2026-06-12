package com.example.Rol.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class AgregarRol {
    
    @NotBlank
    private String nombre_rol;
    @NotBlank
    private String descripcion_rol;
}
