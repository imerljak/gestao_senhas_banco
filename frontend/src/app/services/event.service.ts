import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private _senhaChamada: Subject<string> = new Subject<string>();

  constructor() { }

  get senhaChamada(): Subject<string> {
    return this._senhaChamada;
  }
}
