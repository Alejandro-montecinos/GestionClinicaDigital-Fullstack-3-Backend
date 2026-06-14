package com.ClinicaIntegral.paciente.model.dto;

import lombok.Data;

@Data
public class PacienteDto {

    final  String nombrePaciente;
    
    final  int persona_idPersona;
    
    final  int convenio_id_convenio;
}
