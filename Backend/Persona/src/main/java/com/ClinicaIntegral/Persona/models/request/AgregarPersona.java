package com.ClinicaIntegral.Persona.models.request;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarPersona {
    

    @NotBlank()
    @UniqueElements(message = "El run no se puede repetir ")
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
    @UniqueElements(message = "El correo no se puede repetir ")
    private String correo;

    @NotBlank
    private String contrasenia;

    @NotBlank
    private String direccion;

    @NotBlank
    private int comunaIdComuna;

    @NotBlank
    private int rolIdRol;
}
