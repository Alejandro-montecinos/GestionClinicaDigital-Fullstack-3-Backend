import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NavbarComponent } from '../navbar-component/navbar-component';
import { LoginService } from '../../services/login-services';
import { PersonaModel } from '../../models/PersonaModel';

@Component({
  selector: 'app-dashboard-persona-component',
  standalone: true,
  imports: [CommonModule, NavbarComponent],
  templateUrl: './dashboard-persona-component.html',
  styleUrl: './dashboard-persona-component.scss',
})
export class DashboardPersonaComponent implements OnInit {
  private loginService = inject(LoginService);
  private router = inject(Router);

  usuario: PersonaModel | null = null;

  ngOnInit(): void {
    this.usuario = this.loginService.obtenerUsuarioLogueado();

    if (!this.usuario) {
      this.router.navigate(['/login']);
    }
  }

  get nombreCompleto(): string {
    if (!this.usuario) return '';

    return `${this.usuario.nombre} ${this.usuario.apellido_paterno} ${this.usuario.apellido_materno}`;
  }

  cerrarSesion(): void {
    this.loginService.cerrarSesion();
    this.router.navigate(['/login']);
  }
}