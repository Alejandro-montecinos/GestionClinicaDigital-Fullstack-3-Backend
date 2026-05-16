import { inject, Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { lastValueFrom } from 'rxjs';

import { ConsultaMedicaModel } from '../models/consultaMedicaModel';

@Injectable({
  providedIn: 'root'
})
export class ConsultaMedicaServices {

  private http = inject(HttpClient);

  private apiUrl = 'http://localhost:6161/consultas';

  async obtenerConsultas() {

    return await lastValueFrom(
      this.http.get<ConsultaMedicaModel[]>(this.apiUrl)
    );
  }

  async crearConsulta(consulta: ConsultaMedicaModel) {

    return await lastValueFrom(
      this.http.post<ConsultaMedicaModel>(this.apiUrl, consulta)
    );
  }

}