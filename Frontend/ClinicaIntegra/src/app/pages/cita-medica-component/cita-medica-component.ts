import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { NavbarComponent } from '../navbar-component/navbar-component';
import { CitaMedicaService } from '../../services/cita-medica-service';
import { CitaMedica } from '../../models/CitaMedicaModel';

@Component({
  selector: 'app-cita-medica',
  standalone: true,
  imports: [CommonModule, FormsModule, NavbarComponent],
  templateUrl: './cita-medica-component.html',
  styleUrls: ['./cita-medica-component.scss']
})
export class CitaMedicaComponent implements OnInit {
  private citaService = inject(CitaMedicaService);
  private router = inject(Router);

  listaCitas: CitaMedica[] = [];
  mostrarModalCitas: boolean = false;
  idPacienteLogueado: number = 1;

  // ==========================================
  // PRIMERA CORRECCIÓN: Justo aquí arriba
  // ==========================================
  nuevaCita: CitaMedica = {
    fechaCita: '',
    horaAgendadaCita: '',
    motivoCita: '',
    estadoCita: 'Pendiente',
    pacienteIdPaciente: 1,
    medicoIdMedico: 1
  };

  ngOnInit(): void {
    this.obtenerIdPaciente();
    
    if (localStorage.getItem('abrir_modal_citas') === 'true') {
      localStorage.removeItem('abrir_modal_citas');
      this.abrirModal();
    }
  }

  obtenerIdPaciente() {
    const usuarioRaw = localStorage.getItem('usuario') || localStorage.getItem('persona');
    if (usuarioRaw) {
      const datos = JSON.parse(usuarioRaw);
      const idDetectado = datos.idPaciente || datos.id_paciente || datos.id;
      this.idPacienteLogueado = idDetectado ? Number(idDetectado) : 1;
    } else {
      this.idPacienteLogueado = 1;
    }
    this.nuevaCita.pacienteIdPaciente = this.idPacienteLogueado;
  }

  abrirModal() {
    this.mostrarModalCitas = true;
    this.cargarCitas();
  }

  cerrarModal() {
    this.mostrarModalCitas = false;
  }

  cargarCitas() {
    this.citaService.listarCitas().subscribe({
      next: (citas) => {
        if (citas && citas.length > 0) {
          this.listaCitas = citas.filter(c => Number(c.pacienteIdPaciente) === Number(this.idPacienteLogueado));
        } else {
          this.listaCitas = [];
        }
      },
      error: (err) => {
        console.error('Error al conectar con el backend:', err);
      }
    });
  }

  guardarCita() {
    this.nuevaCita.pacienteIdPaciente = this.idPacienteLogueado;
    this.citaService.crearCita(this.nuevaCita).subscribe({
      next: () => {
        alert('¡Tu cita médica ha sido agendada con éxito!');
        this.reestablecerFormulario();
        this.abrirModal();
      },
      error: (err) => {
        console.error('Error al guardar la cita:', err);
        alert('Hubo un problema al procesar la cita.');
      }
    });
  }

  // ==========================================
  // SEGUNDA CORRECCIÓN: Casi al final del archivo
  // ==========================================
  reestablecerFormulario() {
    this.nuevaCita = {
      fechaCita: '',
      horaAgendadaCita: '',
      motivoCita: '',
      estadoCita: 'Pendiente',
      pacienteIdPaciente: this.idPacienteLogueado,
      medicoIdMedico: 1
    };
  }

  volverAlInicio() {
    this.router.navigate(['/inicio-paciente']);
  }
}