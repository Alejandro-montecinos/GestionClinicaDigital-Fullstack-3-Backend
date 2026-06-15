import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { NavbarComponent } from '../navbar-component/navbar-component';
import { ConsultaMedicaService } from '../../services/consulta-medica-services';
import { ConsultaMedica } from '../../models/consultaMedicaModel';

@Component({
  selector: 'app-inicio-medico',
  standalone: true,
  imports: [CommonModule, FormsModule, NavbarComponent],
  templateUrl: './inicio-medico-component.html',
  styleUrls: ['./inicio-medico-component.scss']
})
export class InicioMedicoComponent implements OnInit {
  private consultaService = inject(ConsultaMedicaService);
  private router = inject(Router);

  nombreDoctor: string = 'Especialista';
  idMedicoLogueado: number = 1;
  listaConsultas: ConsultaMedica[] = [];
  mostrarModalConsultas: boolean = false;

  // CORREGIDO: Objeto limpio alineado con tu ConsultaMedica del Backend
  nuevaConsulta: ConsultaMedica = {
    fechaConsulta_ConsultaMedica: '',
    sintomas_ConsultaMedica: '',
    observaciones_ConsultaMedica: '',
    diagnostico_ConsultaMedica: '',
    medico_idMedico: 1
  };

  ngOnInit(): void {
    this.obtenerDatosDoctor();
    
    if (localStorage.getItem('abrir_modal_consultas') === 'true') {
      localStorage.removeItem('abrir_modal_consultas');
      this.abrirModal();
    }
  }

  obtenerDatosDoctor() {
    const usuarioRaw = localStorage.getItem('usuario') || localStorage.getItem('persona');
    if (usuarioRaw) {
      const datos = JSON.parse(usuarioRaw);
      const idDetectado = datos.idMedico || datos.id_medico || datos.medico_idMedico || datos.id;
      this.idMedicoLogueado = idDetectado ? Number(idDetectado) : 1;
      this.nombreDoctor = datos.nombre || datos.persona?.nombre || 'Doctor(a)';
    } else {
      this.idMedicoLogueado = 1; 
    }
    this.nuevaConsulta.medico_idMedico = this.idMedicoLogueado;
  }

  abrirModal() {
    this.mostrarModalConsultas = true;
    this.cargarConsultasEmisores();
  }

  cerrarModal() {
    this.mostrarModalConsultas = false;
  }

  cargarConsultasEmisores() {
    this.consultaService.listarConsultas().subscribe({
      next: (consultas) => {
        console.log('Datos puros del puerto 6161:', consultas);
        if (consultas && consultas.length > 0) {
          this.listaConsultas = consultas.filter(c => Number(c.medico_idMedico) === Number(this.idMedicoLogueado));
        } else {
          this.listaConsultas = [];
        }
      },
      error: (err) => {
        console.error('Error al traer las consultas del backend:', err);
      }
    });
  }

  guardarConsulta() {
    this.nuevaConsulta.medico_idMedico = this.idMedicoLogueado;
    this.consultaService.crearConsulta(this.nuevaConsulta).subscribe({
      next: () => {
        alert('¡La consulta médica ha sido registrada con éxito!');
        this.reestablecerFormulario();
        this.abrirModal(); 
      },
      error: (err) => {
        console.error('Error al guardar la consulta:', err);
        alert('Hubo un problema al procesar la consulta.');
      }
    });
  }

  reestablecerFormulario() {
    this.nuevaConsulta = {
      fechaConsulta_ConsultaMedica: '',
      sintomas_ConsultaMedica: '',
      observaciones_ConsultaMedica: '',
      diagnostico_ConsultaMedica: '',
      medico_idMedico: this.idMedicoLogueado
    };
  }

  volverAlInicio() {
    this.router.navigate(['/inicio-medico']); 
  }
}