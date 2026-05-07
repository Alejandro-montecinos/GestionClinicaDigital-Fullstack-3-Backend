import { Component, inject, OnInit} from '@angular/core';
import { RolServices } from '../../services/rol-services';
import { RolModel } from '../../models/RolModel';

@Component({
  selector: 'app-rol-component',
  imports: [],
  templateUrl: './Rol-component.html',
  styleUrl: './Rol-component.scss',
})
export class RolComponent implements OnInit {
  
  private RolServices = inject(RolServices)


  rol! : RolModel


  async ngOnInit() {
    try {
      
      this.rol = await this.RolServices.obtenerRol();
      console.log(this.rol);
      
    } catch (error) {
      console.log("Error al obtener el rol",error);
      
    }
  }

  

}
