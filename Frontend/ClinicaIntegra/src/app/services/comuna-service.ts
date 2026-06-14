import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { lastValueFrom } from 'rxjs';
import { ComunaModel } from '../models/comunaModel';


@Injectable({
  providedIn: 'root',
})
export class ComunaService {

  private http = inject(HttpClient);
  private apiUrl = environment.apiUrlComuna;

  async obtenerComunas(): Promise<ComunaModel[]> {
    return await lastValueFrom(this.http.get<ComunaModel[]>(this.apiUrl));
  }

}
