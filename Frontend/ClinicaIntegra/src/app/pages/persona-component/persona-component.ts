import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { PersonaServices } from '../../services/persona-services';
import { PersonaModel } from '../../models/PersonaModel';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../navbar-component/navbar-component';

@Component({
  selector: 'app-persona-component',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, NavbarComponent],
  templateUrl: './persona-component.html',
  styleUrl: './persona-component.scss',
})
export class PersonaComponent implements OnInit {
  private fb = inject(FormBuilder);
  private personaService = inject(PersonaServices);

  personaForm: FormGroup;
  cargando = false;
  mensajeExito = '';
  mensajeError = '';

  constructor() {
    this.personaForm = this.fb.group({
      idPersona: [0],
      nombre: ['', [Validators.required, Validators.minLength(2)]],
      apellido_paterno: ['', [Validators.required, Validators.minLength(2)]],
      apellido_materno: ['', [Validators.required, Validators.minLength(2)]],
      run: ['', [Validators.required, Validators.pattern(/^\d{7,8}-[\dkK]$/)]],
      correo: ['', [Validators.required, Validators.email]],
      direccion: ['', [Validators.required, Validators.minLength(5)]],
      fecha_nacimiento: ['', Validators.required],
      telefono: ['', [Validators.required, Validators.pattern(/^\+569\d{8}$/)]],
      COMUNA_id_comuna: [null, Validators.required],
      ROL_id_rol: [2]
    });
  }

  async ngOnInit() {
    // Si quieres precargar datos en modo edición, usa este bloque.
    // Si será solo registro, puedes eliminar todo el contenido de ngOnInit.
  }

  get f() {
    return this.personaForm.controls;
  }

  campoInvalido(campo: string): boolean {
    const control = this.personaForm.get(campo);
    return !!control && control.invalid && control.touched;
  }

  async registrarPersona() {
    this.mensajeExito = '';
    this.mensajeError = '';

    if (this.personaForm.invalid) {
      this.personaForm.markAllAsTouched();
      return;
    }

    this.cargando = true;

    try {
      const nuevaPersona: PersonaModel = {
        ...this.personaForm.getRawValue(),
        idPersona: 0,
        ROL_id_rol: 2
      };

      const respuesta = await this.personaService.crearPersona(nuevaPersona);
      console.log('Persona registrada:', respuesta);

      this.mensajeExito = 'Usuario registrado correctamente en la clínica.';
      this.personaForm.reset({
        idPersona: 0,
        nombre: '',
        apellido_paterno: '',
        apellido_materno: '',
        run: '',
        correo: '',
        direccion: '',
        fecha_nacimiento: '',
        telefono: '',
        COMUNA_id_comuna: null,
        ROL_id_rol: 2
      });
    } catch (error) {
      console.error('Error al registrar persona', error);
      this.mensajeError = 'No se pudo registrar el usuario. Verifica la API o los datos ingresados.';
    } finally {
      this.cargando = false;
    }
  }
}