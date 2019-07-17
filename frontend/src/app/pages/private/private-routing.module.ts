import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PrivateComponent } from './private.component';
import { PrivateGuardService } from 'src/app/guards/private-guard.service';


const routes: Routes = [
  { path: '', component: PrivateComponent, canActivate: [PrivateGuardService] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PrivateRoutingModule { }
