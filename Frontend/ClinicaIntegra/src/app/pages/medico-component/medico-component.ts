import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { firstValueFrom } from 'rxjs';

import { NavbarComponent } from '../navbar-component/navbar-component';
import { MedicoModel } from '../../models/MedicoModel';
import { MedicoService } from '../../services/medico-service';

@Component({
  selector: 'app-medico-component',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, NavbarComponent],
  templateUrl: './medico-component.html',
  styleUrl: './medico-component.scss',
})
export class MedicoComponent {
  private fb = inject(FormBuilder);
  private medicoService = inject(MedicoService);

  medicoForm: FormGroup;
  cargando = false;
  mensajeExito = '';
  mensajeError = '';

  constructor() {
     this.medicoForm = this.fb.group({
      nombre: ['', [Validators.required, Validators.minLength(2)]],
      apellido_paterno: ['', [Validators.required, Validators.minLength(2)]],
      apellido_materno: ['', [Validators.required, Validators.minLength(2)]],
      correo: ['', [Validators.required, Validators.email]],
      direccion: ['', [Validators.required, Validators.minLength(5)]],
      fecha_nacimiento: ['', Validators.required],
      personaRun: ['', [Validators.required, Validators.pattern(/^\d{7,8}-[\dkK]$/)]],
      telefono: ['', [Validators.required, Validators.pattern(/^\+569\d{8}$/)]],
      nombre_cargo: ['', [Validators.required, Validators.minLength(3)]],
      nombre_especialidad: ['', [Validators.required, Validators.minLength(3)]],
      COMUNA_id_comuna: [null, Validators.required],
      ROL_id_rol: [2, Validators.required]
    });
  }

  get f() {
    return this.medicoForm.controls;
  }

  campoInvalido(campo: string): boolean {
    const control = this.medicoForm.get(campo);
    return !!control && control.invalid && control.touched;
  }

  async registrarMedico() {
    this.mensajeExito = '';
    this.mensajeError = '';

    if (this.medicoForm.invalid) {
      this.medicoForm.markAllAsTouched();
      return;
    }

    this.cargando = true;

    try {
      const nuevoMedico: MedicoModel = {
        ...this.medicoForm.getRawValue(),
        ROL_id_rol: 2
      };

      const respuesta = await firstValueFrom(
        this.medicoService.crearMedico(nuevoMedico)
      );

      console.log('Médico registrado:', respuesta);

      this.mensajeExito = 'Médico registrado correctamente.';
      this.medicoForm.reset({
        nombre: '',
        apellido_paterno: '',
        apellido_materno: '',
        correo: '',
        direccion: '',
        fecha_nacimiento: '',
        persona_run: '',
        telefono: '',
        nombre_cargo: '',
        nombre_especialidad: '',
        COMUNA_id_comuna: null,
        ROL_id_rol: 2
      });
    } catch (error) {
      console.error('Error al registrar médico', error);
      this.mensajeError = 'No se pudo registrar el médico. Verifica la API o los datos ingresados.';
    } finally {
      this.cargando = false;
    }
  }
}