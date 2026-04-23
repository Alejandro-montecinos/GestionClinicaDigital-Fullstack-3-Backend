package com.ClinicaIntegral.Persona.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarPersona {
    
    @NotBlank
    private int idPersona;

    @NotBlank
    private String run;

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

    @NotBlank
    private int COMUNA_id_comuna;

    @NotBlank
    private int ROL_id_rol;

}
