import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, CanActivate, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PrivateGuardService implements CanActivate{

  constructor(private _router: Router) { }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    let response = confirm("Você está entrando em uma área restrita, tem certeza do que está fazendo??");

    if(response) {
      return true;
    }

    return this._router.navigate(['public']);
  }
}
