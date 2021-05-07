import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
  userRole = ''
  invalidLogin = false

  constructor(private router: Router,
    private loginservice: AuthenticationService) { }

  ngOnInit() {
  }

  checkLogin() {
    (this.loginservice.authenticate(this.username, this.password).subscribe(
      data => {
        sessionStorage.setItem('userRole',this.userRole)
        if(sessionStorage.getItem('userRole')=='ROLE_USER')
            this.router.navigate(['userDashboard'])
        else if(sessionStorage.getItem('userRole')=='ROLE_ADMIN')
            this.router.navigate(['adminDashboard'])
        else
            this.router.navigate(['superadminDashboard'])
        this.invalidLogin = false
      },
      error => {
        this.invalidLogin = true

      }
    )
    );

  }

}
