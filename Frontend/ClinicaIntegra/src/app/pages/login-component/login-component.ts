import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NavbarComponent } from '../navbar-component/navbar-component';
import { LoginService } from '../../services/login-services';
import { LoginModel } from '../../models/LoginModel';

@Component({
  selector: 'app-login-component',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, NavbarComponent],
  templateUrl: './login-component.html',
  styleUrl: './login-component.scss',
})
export class LoginComponent {
  private fb = inject(FormBuilder);
  private loginService = inject(LoginService);
  private router = inject(Router);

  loginForm: FormGroup;
  cargando = false;
  mensajeError = '';
  mensajeExito = '';

  constructor() {
    this.loginForm = this.fb.group({
      correo: ['', [Validators.required, Validators.email]],
      contrasenia: ['', [Validators.required, Validators.minLength(8)]],
    });
  }

  get f() {
    return this.loginForm.controls;
  }

  campoInvalido(campo: string): boolean {
    const control = this.loginForm.get(campo);
    return !!control && control.invalid && control.touched;
  }

  async iniciarSesion() {
    this.mensajeError = '';
    this.mensajeExito = '';

    if (this.loginForm.invalid) {
      this.loginForm.markAllAsTouched();
      return;
    }

    this.cargando = true;

    try {
      const credenciales: LoginModel = this.loginForm.getRawValue();
      const respuesta = await this.loginService.iniciarSesion(credenciales);

      console.log('Login correcto:', respuesta);
      this.mensajeExito = 'Inicio de sesión correcto. Redirigiendo...';

      setTimeout(() => {
        this.router.navigate(['/dashboard-persona']);
      }, 800);

    } catch (error) {
      console.error('Error al iniciar sesión', error);
      this.mensajeError = 'No se pudo iniciar sesión. Verifica tu correo y contraseña.';
    } finally {
      this.cargando = false;
    }
  }
}