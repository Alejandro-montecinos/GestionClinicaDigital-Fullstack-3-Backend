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
  mostrarModal = false;

  ngOnInit() {
    this.estaEnDashboard = this.router.url.includes('inicio-paciente');

    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe(() => {
      this.estaEnDashboard = this.router.url.includes('inicio-paciente');
    });
  }

  abrirModal() { this.mostrarModal = true; }
  cerrarModal() { this.mostrarModal = false; }

  confirmarSalida() {
    this.mostrarModal = false;
    this.estaEnDashboard = false;
    this.router.navigate(['/']); // Redirige al Inicio general
  }
}