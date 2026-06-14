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

seleccionarRol(rol: string) {
  console.log('Rol seleccionado:', rol);
  
  if (rol === 'paciente') {
    this.router.navigate(['/login', { tipo: rol }]);

  } else if (rol === 'doctor') {
    this.router.navigate(['/login']);
    
  } else {
    this.router.navigate(['/login']); 
  }
}
}