import { Component, OnInit } from '@angular/core';
import { PublicService } from 'src/app/services/public-service.service';

@Component({
  selector: 'app-senha-atual',
  templateUrl: './senha-atual.component.html',
  styleUrls: ['./senha-atual.component.scss']
})
export class SenhaAtualComponent implements OnInit {

  senhaAtual: string;

  constructor(private service: PublicService) { }

  ngOnInit() {
    this.service.ouvirChamadaDeSenha()
      .subscribe(senha => {
        console.log(senha);
        this.senhaAtual = senha;
      }, error => console.error(error));
  }

}
