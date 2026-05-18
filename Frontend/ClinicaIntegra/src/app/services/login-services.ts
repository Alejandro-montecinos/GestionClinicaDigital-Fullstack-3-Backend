import { inject, Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { lastValueFrom } from 'rxjs';
import { LoginModel } from '../models/LoginModel';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private http = inject(HttpClient);
  private apiUrl = `${environment.apiUrl}/login`;

  async iniciarSesion(login: LoginModel) {
    return await lastValueFrom(this.http.post<any>(this.apiUrl, login));
  }
}