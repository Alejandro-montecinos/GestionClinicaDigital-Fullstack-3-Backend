import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ConsultaMedica } from '../models/consultaMedicaModel';

@Injectable({
  providedIn: 'root'
})
export class ConsultaMedicaService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:6161/consultaMedica'; // Puerto 6161 de tu backend

  listarConsultas(): Observable<ConsultaMedica[]> {
    return this.http.get<ConsultaMedica[]>(this.apiUrl);
  }

  obtenerConsultaPorId(id: number): Observable<ConsultaMedica> {
    return this.http.get<ConsultaMedica>(`${this.apiUrl}/${id}`);
  }

  crearConsulta(consulta: ConsultaMedica): Observable<ConsultaMedica> {
    return this.http.post<ConsultaMedica>(this.apiUrl, consulta);
  }

  actualizarConsulta(id: number, consulta: ConsultaMedica): Observable<ConsultaMedica> {
    return this.http.put<ConsultaMedica>(`${this.apiUrl}/${id}`, consulta);
  }

  eliminarConsulta(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/${id}`, { responseType: 'text' as 'json' });
  }
}