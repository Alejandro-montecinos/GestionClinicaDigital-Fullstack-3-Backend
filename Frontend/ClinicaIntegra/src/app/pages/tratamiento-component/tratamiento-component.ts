import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-tratamiento-component',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './Tratamiento-component.html',
  styleUrls: ['./Tratamiento-component.scss'],
})
export class TratamientoComponent implements OnInit {

  private http = inject(HttpClient);

  apiUrl = 'http://localhost:6666/tratamiento';


  tratamientos: any[] = [];

  tratamiento = {
    idTratamiento: 0,
    descripcion_Tratamiento: '',
    indicaciones_Tratamiento: '',
    consultaId: 0
  };

  editando = false;

  ngOnInit(): void {
    this.obtenerTratamientos();
  }

  // LISTAR
  obtenerTratamientos() {

    this.http.get<any[]>(this.apiUrl)
      .subscribe({
        next: (data) => {
          this.tratamientos = data;
        },
        error: (err) => {
          console.error('ERROR GET:', err);
        }
      });

  }

  // GUARDAR
  guardarTratamiento() {

    if(this.editando){

      this.http.put(
        `${this.apiUrl}/${this.tratamiento.idTratamiento}`,
        this.tratamiento
      ).subscribe({

        next: () => {

          this.obtenerTratamientos();
          this.limpiar();

        },

        error: (err) => {
          console.error('ERROR PUT:', err);
        }

      });

    }else{

      this.http.post(this.apiUrl, this.tratamiento)
        .subscribe({

          next: () => {

            this.obtenerTratamientos();
            this.limpiar();

          },

          error: (err) => {
            console.error('ERROR POST:', err);
          }

        });

    }

  }

  // EDITAR
  editarTratamiento(t: any){

    this.editando = true;

    this.tratamiento = {
      ...t
    };

  }

  // ELIMINAR
  eliminarTratamiento(id: number){

    if(confirm("¿Eliminar tratamiento?")){

      this.http.delete(`${this.apiUrl}/${id}`)
        .subscribe({

          next: () => {

            this.obtenerTratamientos();

          },

          error: (err) => {
            console.error('ERROR DELETE:', err);
          }

        });

    }

  }

  // LIMPIAR
  limpiar(){

    this.tratamiento = {
      idTratamiento: 0,
      descripcion_Tratamiento: '',
      indicaciones_Tratamiento: '',
      consultaId: 0
    };

    this.editando = false;

  }

}