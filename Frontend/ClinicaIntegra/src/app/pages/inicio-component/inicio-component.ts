import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar-component/navbar-component';

@Component({
  selector: 'app-inicio-component',
  standalone: true,
  imports: [NavbarComponent],
  templateUrl: './inicio-component.html',
  styleUrls: ['./inicio-component.scss']
})
export class InicioComponent {
}