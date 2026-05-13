import { inject, Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { PersonaModel } from '../models/PersonaModel';
import { lastValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PersonaServices {
  private http = inject(HttpClient);
  private apiUrl = `${environment.apiUrl}`; // ajusta esta ruta según tu backend

  async obtenerPersona() {
    return await lastValueFrom(this.http.get<PersonaModel>(this.apiUrl));
  }

  async crearPersona(persona: PersonaModel) {
    return await lastValueFrom(this.http.post<PersonaModel>(this.apiUrl, persona));
  }
}