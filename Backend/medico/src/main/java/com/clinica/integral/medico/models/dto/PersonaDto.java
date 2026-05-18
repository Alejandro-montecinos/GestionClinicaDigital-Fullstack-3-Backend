package com.clinica.integral.medico.models.dto;

public record PersonaDto (String run,
    String nombre,
    String apellido_paterno,
    String apellido_materno,
    String fecha_nacimiento,
    String telefono,
    String correo,
    String direccion,
    int COMUNA_id_comuna,
    int ROL_id_rol
) {}