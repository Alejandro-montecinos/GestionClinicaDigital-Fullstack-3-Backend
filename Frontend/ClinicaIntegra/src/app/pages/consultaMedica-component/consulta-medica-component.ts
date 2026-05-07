import { Component, inject, OnInit} from '@angular/core';
import { ConsultaMedicaServices } from '../../services/consulta-medica-services';
import { ConsultaMedicaModel } from '../../models/consultaMedicaModel';

@Component({
  selector: 'app-consulta-medica-component',
  imports: [],
  templateUrl: './Consulta-Medica-component.html',
  styleUrl: './Consulta-Medica-component.scss',
})
export class ConsultaMedicaComponent implements OnInit {
  
  private ConsultaMedicaServices = inject(ConsultaMedicaServices)


  consultaMedica! : ConsultaMedicaModel


  async ngOnInit() {
    try {
      
      this.consultaMedica = await this.ConsultaMedicaServices.obtenerConsultaMedica();
      console.log(this.consultaMedica);
      
    } catch (error) {
      console.log("Error al obtener la consulta médica",error);
      
    }
  }

  

}
