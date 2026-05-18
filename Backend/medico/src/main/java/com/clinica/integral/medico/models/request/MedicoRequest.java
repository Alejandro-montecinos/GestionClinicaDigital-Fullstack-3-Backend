package com.clinica.integral.medico.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MedicoRequest {

 
    @NotBlank
    private String personaRun;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido_paterno;
    @NotBlank
    private String apellido_materno;
    @NotBlank
    private String fecha_nacimiento;
    @NotBlank
    private String telefono;
    @NotBlank
    private String correo;
    @NotBlank
    private String direccion;
    @NotNull
    private int COMUNA_id_comuna;
    @NotNull
    private int ROL_id_rol;
    @NotBlank
    private String nombre_cargo;
    @NotBlank
    private String nombre_especialidad;

    
}
