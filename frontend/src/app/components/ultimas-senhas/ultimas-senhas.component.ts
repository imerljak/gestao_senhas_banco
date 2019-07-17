import { Component, OnInit } from '@angular/core';
import { EventService } from 'src/app/services/event.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-ultimas-senhas',
  templateUrl: './ultimas-senhas.component.html',
  styleUrls: ['./ultimas-senhas.component.scss']
})
export class UltimasSenhasComponent implements OnInit {

  senhas: string[] = [];

  private _subscription: Subscription;

  constructor(private events: EventService) { }

  ngOnInit() {
    this._subscription = this.events.senhaChamada
      .subscribe(s => {
        if (s) {
          this.senhas.unshift(s);
        }
      })
  }

  ngOnDestroy() {
    this._subscription.unsubscribe();
  }

}
