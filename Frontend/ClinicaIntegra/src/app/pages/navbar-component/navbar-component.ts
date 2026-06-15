import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, NavigationEnd, RouterLink, RouterLinkActive } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './navbar-component.html',
  styleUrls: ['./navbar-component.scss']
})
export class NavbarComponent implements OnInit {
  private router = inject(Router);
  
  estaEnDashboard = false;
  esMedico = false; // Nueva variable para controlar la vista del Doctor
  mostrarModal = false;

  ngOnInit() {
    this.evaluarEstadoSesion(this.router.url);

    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe((event: any) => {
      this.evaluarEstadoSesion(event.urlAfterRedirects);
    });
  }

  evaluarEstadoSesion(url: string) {
    // Comprobamos si hay rastro de sesión activa
    const existeUsuario = localStorage.getItem('usuario') || localStorage.getItem('persona');
    
    // RUTA MÉDICO
    if (url.includes('inicio-medico') || url.includes('consulta-medica')) {
      this.estaEnDashboard = true;
      this.esMedico = true;
    } 
    // RUTA PACIENTE
    else if (url.includes('inicio-paciente') || url.includes('cita-medica')) {
      this.estaEnDashboard = true;
      this.esMedico = false;
    } 
    // RUTA LOGIN / SELECCIÓN DE USUARIO
    else {
      this.estaEnDashboard = false; // Forzamos falso aquí para que limpie los paneles en selección de usuario
      this.esMedico = false;
    }
  }

  irAAgendar() {
    this.router.navigate(['/cita-medica']);
  }

  activarHistorialCitas() {
    localStorage.setItem('abrir_modal_citas', 'true');
    if (this.router.url.includes('cita-medica')) {
      window.location.reload();
    } else {
      this.router.navigate(['/cita-medica']);
    }
  }

  abrirModal() { this.mostrarModal = true; }
  cerrarModal() { this.mostrarModal = false; }

  confirmarSalida() {
    this.mostrarModal = false;
    this.estaEnDashboard = false;
    this.esMedico = false;
    localStorage.clear(); 
    this.router.navigate(['/']);
  }
}