import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NavbarComponent } from '../navbar-component/navbar-component';
import { LoginService } from '../../services/login-services';
import { LoginRequest } from '../../models/LoginRequest';
import { LoginResponse } from '../../models/LoginResponse';

@Component({
  selector: 'app-login-component',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, NavbarComponent],
  templateUrl: './login-component.html',
  styleUrl: './login-component.scss',
})
export class LoginComponent implements OnInit {
  private fb = inject(FormBuilder);
  private loginService = inject(LoginService);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

  loginForm: FormGroup;
  cargando = false;
  mensajeError = '';
  mensajeExito = '';
  esPaciente = false;

  constructor() {
    this.loginForm = this.fb.group({
      correo: ['', [Validators.required, Validators.email]],
      contrasenia: ['', [Validators.required, Validators.minLength(8)]],
    });
  }

  ngOnInit(): void {
    this.route.queryParamMap.subscribe(params => {
      const rolIdRol = Number(params.get('rolIdRol')) || 0;
      this.esPaciente = rolIdRol === 2;
    });
  }

  get f() {
    return this.loginForm.controls;
  }

  campoInvalido(campo: string): boolean {
    const control = this.loginForm.get(campo);
    return !!control && control.invalid && control.touched;
  }

  irARegistro(): void {
    this.router.navigate(['/persona'], {
      queryParams: { rolIdRol: 2 }
    });
  }

  async iniciarSesion(): Promise<void> {
    this.mensajeError = '';
    this.mensajeExito = '';

    if (this.loginForm.invalid) {
      this.loginForm.markAllAsTouched();
      return;
    }

    this.cargando = true;

    try {
      const credenciales: LoginRequest = this.loginForm.getRawValue();
      const respuesta: LoginResponse = await this.loginService.iniciarSesion(credenciales);

      console.log('Login correcto:', respuesta);
      this.mensajeExito = 'Inicio de sesión correcto. Redirigiendo...';

      setTimeout(() => {
        if (respuesta.rolIdRol === 2) {
          this.router.navigate(['/inicio-paciente']);
        } else if (respuesta.rolIdRol === 1) {
          this.router.navigate(['/inicio-admin']);
        } else {
          this.router.navigate(['/']);
        }
      }, 800);

    } catch (error) {
      console.error('Error al iniciar sesión', error);
      this.mensajeError = 'No se pudo iniciar sesión. Verifica tu correo y contraseña.';
    } finally {
      this.cargando = false;
    }
  }
}