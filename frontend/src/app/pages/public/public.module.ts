import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PublicRoutingModule } from './public-routing.module';
import { PublicComponent } from './public.component';
import { SenhaAtualComponent } from 'src/app/components/senha-atual/senha-atual.component';
import { SolicitarSenhaComponent } from 'src/app/components/solicitar-senha/solicitar-senha.component';
import { UltimasSenhasComponent } from 'src/app/components/ultimas-senhas/ultimas-senhas.component';


@NgModule({
  declarations: [
    PublicComponent,
    SenhaAtualComponent,
    SolicitarSenhaComponent,
    UltimasSenhasComponent
  ],
  imports: [
    CommonModule,
    PublicRoutingModule
  ]
})
export class PublicModule { }
