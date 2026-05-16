import { Component, inject } from '@angular/core';
import { NavbarComponent } from '../navbar-component/navbar-component';
import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule
} from '@angular/forms';

import { CommonModule } from '@angular/common';

import { ConsultaMedicaServices } from '../../services/consulta-medica-services';

import { ConsultaMedicaModel } from '../../models/consultaMedicaModel';

@Component({
  selector: 'app-consulta-medica-component',

  standalone: true,

  imports: [
    ReactiveFormsModule,
    CommonModule,
    NavbarComponent
  ],

  templateUrl: './consulta-medica-component.html',

  styleUrl: './consulta-medica-component.scss'
})

export class ConsultaMedicaComponent {

  private fb = inject(FormBuilder);

  private consultaService = inject(ConsultaMedicaServices);

  consultaForm: FormGroup;

  cargando = false;

  mensajeExito = '';

  mensajeError = '';

  consultas: ConsultaMedicaModel[] = [];

  constructor() {

    this.consultaForm = this.fb.group({

      fechaConsulta_ConsultaMedica: ['', Validators.required],

      sintomas_ConsultaMedica: ['', [
        Validators.required,
        Validators.minLength(3)
      ]],

      observaciones_ConsultaMedica: ['', [
        Validators.required,
        Validators.minLength(5)
      ]],

      diagnostico_ConsultaMedica: ['', [
        Validators.required,
        Validators.minLength(3)
      ]],

      pacienteId: [null, Validators.required],

      medicoId: [null, Validators.required]

    });

  }

  campoInvalido(campo: string): boolean {

    const control = this.consultaForm.get(campo);

    return !!control && control.invalid && control.touched;

  }

  async registrarConsulta() {

    this.mensajeExito = '';

    this.mensajeError = '';

    if (this.consultaForm.invalid) {

      this.consultaForm.markAllAsTouched();

      return;
    }

    this.cargando = true;

    try {

      const nuevaConsulta: ConsultaMedicaModel = {

        ...this.consultaForm.getRawValue()

      };

      const respuesta = await this.consultaService.crearConsulta(nuevaConsulta);

      this.consultas.push(respuesta);
      
      console.log('Consulta registrada:', respuesta);

      this.mensajeExito = 'Consulta médica registrada correctamente.';
      setTimeout(() => {

        this.mensajeExito = '';

      }, 4000);
      this.consultaForm.reset({

        fechaConsulta_ConsultaMedica: '',

        sintomas_ConsultaMedica: '',

        observaciones_ConsultaMedica: '',

        diagnostico_ConsultaMedica: '',

        pacienteId: null,

        medicoId: null

      });

    } catch (error) {

      console.error(error);

      this.mensajeError =
        'Error al registrar la consulta médica.';

    } finally {

      this.cargando = false;

    }

  }

}