import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { appUrl } from '../constants';

@Injectable({
  providedIn: 'root'
})
export class PrivateService {

  constructor(private http: HttpClient) { }

  chamarProximaSenha(): Promise<string> {
    return this.http.get<string>(`${appUrl}/gerente/senhas`).toPromise();
  }

  reiniciarContagem(): Promise<any> {
    return this.http.post(`${appUrl}/gerente/senhas`, {}).toPromise();
  }
}
