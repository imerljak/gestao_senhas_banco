import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { appUrl } from '../constants';
import { Observable } from 'rxjs';
import { map, tap } from 'rxjs/operators';
import { StompService } from '@stomp/ng2-stompjs';
import { EventService } from './event.service';

@Injectable({
  providedIn: 'root'
})
export class PublicService {

  constructor(
    private events: EventService,
    private http: HttpClient, 
    private stompService: StompService) { }

  solicitarSenhaNormal(): Promise<string> {
    return this.http.post<string>(`${appUrl}/senhas/gerar-normal`, {}).toPromise();
  }

  solicitarSenhaPreferencial(): Promise<string> {
    return this.http.post<string>(`${appUrl}/senhas/gerar-preferencial`, {}).toPromise();
  }

  ouvirChamadaDeSenha(): Observable<string> {
    return this.stompService.subscribe("/topic/senhaAtual")
      .pipe(
        map(msg => msg.body ? msg.body : null),
        tap(msg => this.events.senhaChamada.next(msg)))
  }

}
