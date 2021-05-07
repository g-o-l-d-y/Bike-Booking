import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient:HttpClient, private router: Router) { }

  authenticate(username:string, password:string) {
    console.log("authenticating")
    return this.httpClient.post<any>('http://localhost:8080/user/login',{username,password}).pipe(
     map(
       userData => {
        sessionStorage.setItem('username',username);
        let tokenStr= 'Bearer '+userData.jwt;
        sessionStorage.setItem('token', tokenStr);
        console.log(userData.jwt);
        return userData;
       }
     )

    );
  }


isUserLoggedIn() {
  let user = sessionStorage.getItem('username')
  console.log(!(user === null))
  return !(user === null)
}

logOut() {
  sessionStorage.removeItem('username')
  sessionStorage.removeItem('token')
  sessionStorage.removeItem('userRole')
  console.log(sessionStorage.getItem('username'))
  this.router.navigate(['/login']);
}

}
