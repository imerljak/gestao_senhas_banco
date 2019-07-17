import { Component, OnInit } from '@angular/core';
import { PrivateService } from 'src/app/services/private.service';
import { EventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-private',
  templateUrl: './private.component.html',
  styleUrls: ['./private.component.scss']
})
export class PrivateComponent implements OnInit {

  proximaSenha: string;
  msgReiniciar: string;

  constructor(private service: PrivateService) { }

  ngOnInit() {
  }

  chamarProximaSenha() {
    this.service.chamarProximaSenha()
    .then(s => {
      if(s == null) {
        this.proximaSenha = 'Não há nenhuma senha aguardando no momento.';
      } else {
        this.proximaSenha = s;
      }
    });
  }

  reiniciarContagemDeSenhas() {
    this.service.reiniciarContagem()
    .then(() => this.msgReiniciar = 'Contagem das senhas reiniciada com sucesso.')
    .catch(e => console.error(e));
  }

}
