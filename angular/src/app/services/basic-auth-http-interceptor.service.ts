import { HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthHttpInterceptorService implements HttpInterceptor{

  token:any=""
  actualToken:string=""
  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    
    if(sessionStorage.getItem('token')!=null)
      this.token=sessionStorage.getItem('token')
    this.actualToken=this.token
    if (sessionStorage.getItem('username') && sessionStorage.getItem('token')) {
      req = req.clone({
        headers: req.headers.append('Authorization',this.actualToken)
      })
    }

    return next.handle(req);

  }
}
