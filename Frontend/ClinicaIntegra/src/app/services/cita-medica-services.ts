import { inject, Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { lastValueFrom } from 'rxjs';
import { CitaMedicaModel } from '../models/citaMedicaModel';

@Injectable({
  providedIn: 'root',
})
export class CitaMedicaServices {

   private http = inject(HttpClient);

  async obtenerCitaMedica(){
    return await lastValueFrom(this.http.get<CitaMedicaModel>(environment.apiUrlCitaMedica));
    
  }

}