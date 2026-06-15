import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { NavbarComponent } from '../navbar-component/navbar-component';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, NavbarComponent],
  templateUrl: './login-component.html',
  styleUrls: ['./login-component.scss']
})
export class LoginComponent implements OnInit {
  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

  loginForm!: FormGroup;
  cargando: boolean = false;
  mensajeExito: string | null = null;
  mensajeError: string | null = null;
  
  tipoUsuarioActual: string = 'paciente';
  mostrarRegistro: boolean = true;

  ngOnInit(): void {
    this.inicializarFormulario();

    this.route.params.subscribe(params => {
      this.tipoUsuarioActual = params['tipo'] || 'paciente';

      if (this.tipoUsuarioActual === 'medico' || this.tipoUsuarioActual === 'admin') {
        this.mostrarRegistro = false;
      } else {
        this.mostrarRegistro = true;
      }
    });
  }

  inicializarFormulario(): void {
    this.loginForm = this.fb.group({
      correo: ['', [Validators.required, Validators.email]],
      contrasenia: ['', [Validators.required, Validators.minLength(8)]]
    });
  }

  campoInvalido(campo: string): boolean {
    const control = this.loginForm.get(campo);
    return !!(control && control.invalid && (control.dirty || control.touched));
  }

  irARegistro(): void {
    this.router.navigate(['/registro-paciente']);
  }

  iniciarSesion(): void {
    if (this.loginForm.invalid) {
      this.mensajeError = 'Por favor, rellene el formulario de forma correcta.';
      return;
    }

    this.cargando = true;
    this.mensajeError = null;
    this.mensajeExito = null;

    setTimeout(() => {
      this.cargando = false;
      const formularioValores = this.loginForm.value;

      if (this.tipoUsuarioActual === 'medico') {
        
        localStorage.setItem('usuario', JSON.stringify({ 
          idMedico: 1, 
          nombre: 'Dr. Alejandro Montecinos', 
          correo: formularioValores.correo 
        }));
        
        this.mensajeExito = 'Sesión iniciada como Médico.';
        
        // REDIRECCIÓN CORREGIDA: Apunta exactamente a tu ruta nueva
        this.router.navigate(['/inicio-medico']);

      } else if (this.tipoUsuarioActual === 'admin') {
        this.router.navigate(['/medico']);
      } else {
        
        localStorage.setItem('usuario', JSON.stringify({ 
          idPaciente: 1, 
          nombre: 'Paciente Ejemplo', 
          correo: formularioValores.correo 
        }));
        
        this.router.navigate(['/inicio-paciente']);
      }
    }, 1200); 
  }
}