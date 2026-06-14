import { inject, Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { lastValueFrom } from 'rxjs';
import { LoginRequest } from '../models/LoginRequest';
import { LoginResponse } from '../models/LoginResponse';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private http = inject(HttpClient);
  private apiUrl = `${environment.apiUrl}/login`;

  private usuarioLogueado: LoginResponse | null = null;

  async iniciarSesion(login: LoginRequest): Promise<LoginResponse> {
    const respuesta = await lastValueFrom(
      this.http.post<LoginResponse>(this.apiUrl, login)
    );

    this.usuarioLogueado = respuesta;
    return respuesta;
  }

  obtenerUsuarioLogueado(): LoginResponse | null {
    return this.usuarioLogueado;
  }

  estaLogueado(): boolean {
    return this.usuarioLogueado !== null;
  }

  cerrarSesion(): void {
    this.usuarioLogueado = null;
  }
}