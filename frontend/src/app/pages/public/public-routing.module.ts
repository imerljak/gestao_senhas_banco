import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PublicComponent } from './public.component';
import { SenhaAtualComponent } from 'src/app/components/senha-atual/senha-atual.component';
import { SolicitarSenhaComponent } from 'src/app/components/solicitar-senha/solicitar-senha.component';
import { UltimasSenhasComponent } from 'src/app/components/ultimas-senhas/ultimas-senhas.component';


const routes: Routes = [
  { path: '', component: PublicComponent }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
  ],
  exports: [RouterModule],
})
export class PublicRoutingModule { }
