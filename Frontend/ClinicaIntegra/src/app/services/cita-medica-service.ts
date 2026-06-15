import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CitaMedica } from '../models/CitaMedicaModel';

@Injectable({
  providedIn: 'root'
})
export class CitaMedicaService {
  private http = inject(HttpClient);
  
  // Sincronizado perfectamente con tu puerto 6767 y tu @RequestMapping("/cita_medica")
  private apiUrl = 'http://localhost:6767/cita_medica'; 

  listarCitas(): Observable<CitaMedica[]> {
    return this.http.get<CitaMedica[]>(this.apiUrl);
  }

  crearCita(cita: CitaMedica): Observable<CitaMedica> {
    return this.http.post<CitaMedica>(this.apiUrl, cita);
  }
}