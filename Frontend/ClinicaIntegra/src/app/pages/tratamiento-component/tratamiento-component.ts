/*import { Component } from '@angular/core';

@Component({
  selector: 'app-tratamiento-component',
  imports: [],
  templateUrl: './tratamiento-component.html',
  styleUrl: './tratamiento-component.scss',
})
export class TratamientoComponent {}*/

import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-tratamiento',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './tratamiento-component.html',
  styleUrls: ['./tratamiento-component.scss'] // 👈 AQUÍ ESTABA EL ERROR
})
export class TratamientoComponent implements OnInit {

  apiUrl = 'http://localhost:6666/api/tratamientos';

  tratamientos: any[] = [];

  form = {
    descripcion_Tratamiento: '',
    indicaciones_Tratamiento: '',
    consultaId: 0
  };

  editando = false;
  idEditando: number | null = null;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.cargar();
  }

  cargar() {
  this.http.get<any[]>(this.apiUrl)
    .subscribe({
      next: data => {
        console.log("DATOS:", data);
        this.tratamientos = data;
      },
      error: err => {
        console.error("ERROR GET:", err);
      }
    });
  }

  guardar() {
  console.log("ENVIANDO:", this.form);

  if (this.editando) {
    this.http.put(`${this.apiUrl}/${this.idEditando}`, this.form)
      .subscribe({
        next: res => {
          console.log("ACTUALIZADO:", res);
          this.reset();
          this.cargar();
        },
        error: err => {
          console.error("ERROR PUT:", err);
        }
      });
  } else {
    this.http.post(this.apiUrl, this.form)
      .subscribe({
        next: res => {
          console.log("GUARDADO:", res);
          this.reset();
          this.cargar();
        },
        error: err => {
          console.error("ERROR POST:", err);
        }
      });
    }
  } 

  editar(t: any) {
    this.editando = true;
    this.idEditando = t.idTratamiento;
    this.form = { ...t };
  }

  eliminar(id: number) {
    this.http.delete(`${this.apiUrl}/${id}`)
      .subscribe(() => this.cargar());
  }

  reset() {
    this.form = {
      descripcion_Tratamiento: '',
      indicaciones_Tratamiento: '',
      consultaId: 0
    };
    this.editando = false;
    this.idEditando = null;
  }
}