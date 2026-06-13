import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../navbar-component/navbar-component';

@Component({
  selector: 'app-inicio-paciente',
  standalone: true,
  imports: [CommonModule, NavbarComponent],
  templateUrl: './inicio-paciente-component.html',
  styleUrls: ['./inicio-paciente-component.scss']
})
export class InicioPacienteComponent {}