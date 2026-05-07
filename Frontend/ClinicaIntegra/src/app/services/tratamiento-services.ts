import { inject, Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { lastValueFrom } from 'rxjs';
import { TratamiendoModel } from '../models/TratamientoModel';

@Injectable({
  providedIn: 'root',
})
export class TratamientoServices {

   private http = inject(HttpClient);

  async obtenerTratamiento(){
    return await lastValueFrom(this.http.get<TratamiendoModel>(environment.apiUrlTratamiento));
    
  }

}