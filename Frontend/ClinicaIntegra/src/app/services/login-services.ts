import { inject, Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { lastValueFrom } from 'rxjs';
import { LoginModel } from '../models/LoginModel';
import { PersonaModel } from '../models/PersonaModel';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private http = inject(HttpClient);
  private apiUrl = `${environment.apiUrl}/login`;

  private usuarioLogueado: PersonaModel | null = null;

  async iniciarSesion(login: LoginModel) {
    const respuesta = await lastValueFrom(
      this.http.post<PersonaModel>(this.apiUrl, login)
    );

    this.usuarioLogueado = respuesta;
    return respuesta;
  }

  obtenerUsuarioLogueado(): PersonaModel | null {
    return this.usuarioLogueado;
  }

  estaLogueado(): boolean {
    return this.usuarioLogueado !== null;
  }

  cerrarSesion(): void {
    this.usuarioLogueado = null;
  }
}