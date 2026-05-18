package com.clinica.integral.medico.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MedicoEditarRequest {

    @NotBlank(message = "El run del médico no es opcional.")
    private String run;

    @NotBlank(message = "El nombre del médico no es opcional.")
    private String nombre;

    @NotBlank(message = "El apellido paterno del médico no es opcional.")
    private String apellido_paterno;

    @NotBlank(message = "El apellido materno del médico no es opcional.")
    private String apellido_materno;

    @NotBlank(message = "La fecha de nacimiento del médico no es opcional.")
    private String fecha_nacimiento;

    @NotBlank(message = "El teléfono del médico no es opcional.")
    private String telefono;

    @NotBlank(message = "El correo del médico no es opcional.")
    private String correo;

    @NotBlank(message = "La dirección del médico no es opcional.")
    private String direccion;

    @NotBlank(message = "El id de la comuna del médico no es opcional.")
    private int COMUNA_id_comuna;

    @NotBlank(message = "El id del rol del médico no es opcional.")
    private int ROL_id_rol;

}
