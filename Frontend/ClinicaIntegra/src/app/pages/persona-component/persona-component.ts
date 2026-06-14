import { Component, inject, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  ValidationErrors,
  ValidatorFn,
  Validators
} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

import { PersonaServices } from '../../services/persona-services';
import { ComunaService } from '../../services/comuna-service';

import { PersonaModel } from '../../models/PersonaModel';
import { ComunaModel } from '../../models/comunaModel';

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
  private comunaService = inject(ComunaService);
  private route = inject(ActivatedRoute);

  cargando = false;
  cargandoComunas = false;
  mensajeExito = '';
  mensajeError = '';

  verContrasenia = false;
  verConfirmacion = false;

  rolIdRol = 2;
  comunas: ComunaModel[] = [];

  personaForm: FormGroup = this.fb.group(
    {
      idPersona: [null],
      nombre: ['', [Validators.required, Validators.minLength(2)]],
      apellido_paterno: ['', [Validators.required, Validators.minLength(2)]],
      apellido_materno: ['', [Validators.required, Validators.minLength(2)]],
      run: ['', [Validators.required, Validators.pattern(/^\d{7,8}-[\dkK]$/)]],
      correo: ['', [Validators.required, Validators.email]],
      contrasenia: ['', [Validators.required, Validators.minLength(8)]],
      confirmarContrasenia: ['', [Validators.required]],
      direccion: ['', [Validators.required, Validators.minLength(5)]],
      fecha_nacimiento: ['', Validators.required],
      telefono: ['', [Validators.required, Validators.pattern(/^\+569\d{8}$/)]],
      comunaIdComuna: [null, Validators.required],
      rolIdRol: [2]
    },
    {
      validators: this.passwordsIgualesValidator('contrasenia', 'confirmarContrasenia')
    }
  );

  ngOnInit(): void {
    this.route.queryParamMap.subscribe(params => {
      const rol = Number(params.get('rolIdRol')) || 2;
      this.rolIdRol = rol;

      this.personaForm.patchValue({
        rolIdRol: rol
      });
    });

    this.cargarComunas();
  }

  async cargarComunas() {
    this.cargandoComunas = true;

    try {
      this.comunas = await this.comunaService.obtenerComunas();
    } catch (error) {
      console.error('Error al cargar comunas', error);
      this.mensajeError = 'No se pudieron cargar las comunas.';
    } finally {
      this.cargandoComunas = false;
    }
  }

  get f() {
    return this.personaForm.controls;
  }

  campoInvalido(campo: string): boolean {
    const control = this.personaForm.get(campo);
    return !!control && control.invalid && control.touched;
  }

  contraseniasNoCoinciden(): boolean {
    const confirm = this.personaForm.get('confirmarContrasenia');
    return !!confirm && confirm.touched && this.personaForm.hasError('passwordMismatch');
  }

  passwordsIgualesValidator(passwordKey: string, confirmPasswordKey: string): ValidatorFn {
    return (formGroup: AbstractControl): ValidationErrors | null => {
      const passwordControl = formGroup.get(passwordKey);
      const confirmPasswordControl = formGroup.get(confirmPasswordKey);

      if (!passwordControl || !confirmPasswordControl) {
        return null;
      }

      const password = passwordControl.value;
      const confirmPassword = confirmPasswordControl.value;

      if (!confirmPassword) {
        return null;
      }

      return password === confirmPassword ? null : { passwordMismatch: true };
    };
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
      const formValue = this.personaForm.getRawValue();

      const nuevaPersona: PersonaModel = {
        nombre: formValue.nombre,
        apellido_paterno: formValue.apellido_paterno,
        apellido_materno: formValue.apellido_materno,
        run: formValue.run,
        correo: formValue.correo,
        contrasenia: formValue.contrasenia,
        direccion: formValue.direccion,
        fecha_nacimiento: formValue.fecha_nacimiento,
        telefono: formValue.telefono,
        comunaIdComuna: Number(formValue.comunaIdComuna),
        rolIdRol: Number(formValue.rolIdRol)
      };

      const respuesta = await this.personaService.crearPersona(nuevaPersona);
      console.log('Persona registrada:', respuesta);

      this.mensajeExito = 'Usuario registrado correctamente en la clínica.';

      this.personaForm.reset({
        idPersona: null,
        nombre: '',
        apellido_paterno: '',
        apellido_materno: '',
        run: '',
        correo: '',
        contrasenia: '',
        confirmarContrasenia: '',
        direccion: '',
        fecha_nacimiento: '',
        telefono: '',
        comunaIdComuna: null,
        rolIdRol: this.rolIdRol
      });
    } catch (error) {
      console.error('Error al registrar persona', error);
      this.mensajeError = 'No se pudo registrar el usuario. Verifica la API o los datos ingresados.';
    } finally {
      this.cargando = false;
    }
  }
}