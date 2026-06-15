export interface CitaMedica {
  idCita?: number;
  fechaCita: string;
  horaAgendadaCita: string;
  motivoCita: string;
  estadoCita: string;
  pacienteIdPaciente: number;
  medicoIdMedico: number;
}