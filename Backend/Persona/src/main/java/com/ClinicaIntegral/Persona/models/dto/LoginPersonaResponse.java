package com.ClinicaIntegral.Persona.models.dto;


import lombok.Data;


@Data
public class LoginPersonaResponse {

    private int idPersona;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String correo;
    private String run;
    private String telefono;
    private String direccion;
    private String fecha_nacimiento;
    private int comunaIdComuna;
    private int rolIdRol;

}
