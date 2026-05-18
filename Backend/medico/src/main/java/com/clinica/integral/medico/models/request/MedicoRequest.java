package com.clinica.integral.medico.models.request;

import lombok.Data;

@Data
public class MedicoRequest {

    private int idMedico;
    private String personaRun;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String fecha_nacimiento;
    private String telefono;
    private String correo;
    private String direccion;
    private int COMUNA_id_comuna;
    private int ROL_id_rol;
    private String nombre_cargo;
    private String nombre_especialidad;
    
}
