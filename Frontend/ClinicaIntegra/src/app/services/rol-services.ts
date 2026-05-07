import { inject, Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { lastValueFrom } from 'rxjs';
import { RolModel } from '../models/RolModel';

@Injectable({
  providedIn: 'root',
})
export class RolServices {

   private http = inject(HttpClient);

  async obtenerRol(){
    return await lastValueFrom(this.http.get<RolModel>(environment.apiUrlRol));
    
  }

}