import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms'; // <-- Agregado ReactiveFormsModule
import { ConsultaMedicaService } from '../../services/consulta-medica-services';
import { ConsultaMedica } from '../../models/consultaMedicaModel';
import { NavbarComponent } from '../navbar-component/navbar-component';

@Component({
  selector: 'app-consulta-medica',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, NavbarComponent],
  templateUrl: './consulta-medica-component.html',
  styleUrls: ['./consulta-medica-component.scss']
})
export class ConsultaMedicaComponent implements OnInit {
  private fb = inject(FormBuilder);
  private consultaService = inject(ConsultaMedicaService);

  // Variables requeridas de forma exacta por tu HTML
  consultaForm!: FormGroup;
  consultas: ConsultaMedica[] = [];
  cargando: boolean = false;
  mensajeExito: string | null = null;
  mensajeError: string | null = null;
  
  idMedicoLogueado: number = 1;
  nombreDoctor: string = 'Especialista';

  ngOnInit(): void {
    this.obtenerDatosDoctor();
    this.inicializarFormulario();
    this.cargarConsultas();
  }

  inicializarFormulario(): void {
    // Vinculado con los formControlName de tu HTML
    this.consultaForm = this.fb.group({
      fechaConsulta_ConsultaMedica: ['', Validators.required],
      sintomas_ConsultaMedica: ['', Validators.required],
      observaciones_ConsultaMedica: ['', Validators.required],
      diagnostico_ConsultaMedica: ['', Validators.required],
      medico_idMedico: [this.idMedicoLogueado]
    });
  }

  obtenerDatosDoctor(): void {
    const usuarioRaw = localStorage.getItem('usuario') || localStorage.getItem('persona');
    if (usuarioRaw) {
      const datos = JSON.parse(usuarioRaw);
      const idDetectado = datos.idMedico || datos.id_medico || datos.medico_idMedico || datos.id;
      this.idMedicoLogueado = idDetectado ? Number(idDetectado) : 1;
      this.nombreDoctor = datos.nombre || datos.persona?.nombre || 'Doctor(a)';
    }
  }

  cargarConsultas(): void {
    this.consultaService.listarConsultas().subscribe({
      next: (data: ConsultaMedica[]) => {
        if (data && data.length > 0) {
          // Filtramos para que el doctor solo visualice su historial
          this.consultas = data.filter(c => Number(c.medico_idMedico) === Number(this.idMedicoLogueado));
        } else {
          this.consultas = [];
        }
      },
      error: (err) => {
        console.error('Error al cargar el historial:', err);
      }
    });
  }

  // Este es el método exacto (ngSubmit) que busca tu HTML
  registrarConsulta(): void {
    if (this.consultaForm.invalid) {
      this.mensajeError = 'Por favor, rellene todos los campos obligatorios.';
      return;
    }

    this.cargando = true;
    this.mensajeExito = null;
    this.mensajeError = null;

    // Aseguramos que viaje con el ID del médico actual
    this.consultaForm.patchValue({ medico_idMedico: this.idMedicoLogueado });

    this.consultaService.crearConsulta(this.consultaForm.value).subscribe({
      next: (respuesta: ConsultaMedica) => {
        this.mensajeExito = '¡La consulta médica ha sido registrada con éxito!';
        this.consultaForm.get('fechaConsulta_ConsultaMedica')?.reset();
        this.consultaForm.get('sintomas_ConsultaMedica')?.reset();
        this.consultaForm.get('observaciones_ConsultaMedica')?.reset();
        this.consultaForm.get('diagnostico_ConsultaMedica')?.reset();
        this.cargando = false;
        this.cargarConsultas(); // Recargamos la tabla automáticamente
      },
      error: (err: any) => {
        console.error('Error al guardar:', err);
        this.mensajeError = 'Hubo un problema al procesar la consulta en el servidor.';
        this.cargando = false;
      }
    });
  }
}