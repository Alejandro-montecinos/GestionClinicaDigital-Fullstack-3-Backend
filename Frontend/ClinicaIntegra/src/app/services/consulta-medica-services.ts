import { inject, Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { lastValueFrom } from 'rxjs';
import { ConsultaMedicaModel } from '../models/consultaMedicaModel';

@Injectable({
  providedIn: 'root',
})
export class ConsultaMedicaServices {

   private http = inject(HttpClient);

  async obtenerConsultaMedica(){
    return await lastValueFrom(this.http.get<ConsultaMedicaModel>(environment.apiUrlConsultaMedica));
    
  }

}