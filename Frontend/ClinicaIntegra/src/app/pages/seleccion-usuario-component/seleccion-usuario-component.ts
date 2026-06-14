import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-seleccion-usuario-component',
  standalone: true,
  imports: [],
  templateUrl: './seleccion-usuario-component.html',
  styleUrl: './seleccion-usuario-component.scss',
})
export class SeleccionUsuarioComponent {

  constructor(private router: Router) {}

  seleccionarRol(idRol: number): void {
    console.log('Rol seleccionado:', idRol);

    this.router.navigate(['/login'], {
      queryParams: { rolIdRol: idRol }
    });
  }
}