import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MedicoModel } from '../models/MedicoModel';

@Injectable({
  providedIn: 'root'
})
export class MedicoService {

  private apiUrl = 'http://localhost:8087/medico';

  constructor(private http: HttpClient) {}

  obtenerMedicos(): Observable<MedicoModel[]> {
    return this.http.get<MedicoModel[]>(this.apiUrl);
  }

  obtenerMedico(): Observable<MedicoModel> {
    return this.http.get<MedicoModel>(this.apiUrl);
  }

  crearMedico(medico: MedicoModel): Observable<MedicoModel> {
    return this.http.post<MedicoModel>(this.apiUrl, medico);
  }
}