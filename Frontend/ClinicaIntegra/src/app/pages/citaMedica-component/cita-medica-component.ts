import { Component, inject, OnInit} from '@angular/core';
import { CitaMedicaModel } from '../../models/citaMedicaModel';
import { CitaMedicaServices } from '../../services/cita-medica-services';

@Component({
  selector: 'app-cita-medica-component',
  imports: [],
  templateUrl: './Cita-Medica-component.html',
  styleUrl: './Cita-Medica-component.scss',
})
export class CitaMedicaComponent implements OnInit {
  
  private CitaMedicaServices = inject(CitaMedicaServices)


  citaMedica! : CitaMedicaModel


  async ngOnInit() {
    try {
      
      this.citaMedica = await this.CitaMedicaServices.obtenerCitaMedica();
      console.log(this.citaMedica);
      
    } catch (error) {
      console.log("Error al obtener la cita médica",error);
      
    }
  }

  

}
