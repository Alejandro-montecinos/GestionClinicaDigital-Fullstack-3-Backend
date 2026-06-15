import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-seleccion-usuario',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './seleccion-usuario-component.html',
  styleUrls: ['./seleccion-usuario-component.scss']
})
export class SeleccionUsuarioComponent {
  private router = inject(Router);

  // Método unificado para redirigir pasando el tipo de usuario exacto en la URL
  irAlLogin(tipo: string): void {
    this.router.navigate(['/login', tipo]);
  }
}