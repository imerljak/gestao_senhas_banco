import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PublicModule } from './pages/public/public.module';


const routes: Routes = [
  {
    path: 'public',
    loadChildren: () => import('./pages/public/public.module').then(m => m.PublicModule)
  }, {
    path: 'private',
    loadChildren: () => import('./pages/private/private.module').then(m => m.PrivateModule)
  },
  {
    path: '',
    redirectTo: 'public',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
