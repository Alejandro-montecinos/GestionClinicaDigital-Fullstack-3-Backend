import { Component, inject, OnInit} from '@angular/core';
import { PersonaServices } from '../../services/persona-services';
import { PersonaModel } from '../../models/PersonaModel';

@Component({
  selector: 'app-persona-component',
  imports: [],
  templateUrl: './persona-component.html',
  styleUrl: './persona-component.scss',
})
export class PersonaComponent implements OnInit {
  
  private PersonaServices = inject(PersonaServices)


  persona! : PersonaModel


  async ngOnInit() {
    try {
      
      this.persona = await this.PersonaServices.obtenerPersona();
      console.log(this.persona);
      
    } catch (error) {
      console.log("Error al obtener persona",error);
      
    }
  }

  

}
