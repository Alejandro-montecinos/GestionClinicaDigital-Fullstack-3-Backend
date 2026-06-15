package com.example.CitaMedica.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor  // <--- ¡ESTA ES LA QUE FALTA Y LE DEVOLVERÁ LA VIDA A TU CONSULTA!
@AllArgsConstructor
@Entity
@Table(name = "cita_medica")
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private int idCita;

    @Column(name = "fecha_cita", nullable = false)
    private String fechaCita;

    @Column(name = "hora_agendada_cita", nullable = false)
    private String horaAgendadaCita;

    @Column(name = "motivo_cita", nullable = false)
    private String motivoCita;

    @Column(name = "estado_cita", nullable = false)
    private String estadoCita;

    @Column(name = "paciente_id_paciente", nullable = false)
    private int pacienteIdPaciente;

    @Column(name = "medico_id_medico", nullable = false)
    private int medicoIdMedico;
}