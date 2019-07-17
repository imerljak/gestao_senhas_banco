import { Component, OnInit } from '@angular/core';
import { PublicService } from 'src/app/services/public-service.service';
import { EventService } from 'src/app/services/event.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-solicitar-senha',
  templateUrl: './solicitar-senha.component.html',
  styleUrls: ['./solicitar-senha.component.scss']
})
export class SolicitarSenhaComponent implements OnInit {

  senhaAtual: string;
  isLoading: boolean;
  hasSenha: boolean;

  constructor(private service: PublicService) { }

  ngOnInit() {}

  solicitarSenhaNormal() {
    this.isLoading = true;
    this._handleSolicitacaoSenha(this.service.solicitarSenhaNormal());
  }

  solicitarSenhaPreferencial() {
    this.isLoading = true;
    this._handleSolicitacaoSenha(this.service.solicitarSenhaPreferencial())
  }

  private _handleSolicitacaoSenha(promise: Promise<string>) : void {
    promise.then(s => {
      this.senhaAtual = s;
      this.isLoading = false;
    })
    .catch(e => console.error(e));
  }

}
