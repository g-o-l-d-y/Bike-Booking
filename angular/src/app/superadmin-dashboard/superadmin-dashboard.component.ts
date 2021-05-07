import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-superadmin-dashboard',
  templateUrl: './superadmin-dashboard.component.html',
  styleUrls: ['./superadmin-dashboard.component.css']
})
export class SuperadminDashboardComponent implements OnInit {
  users:any
  constructor(private http:HttpClient, public loginService: AuthenticationService,private router:Router) { }

  ngOnInit(): void {

    let obs = this.http.get("http://localhost:8080/superadmin/dashboard")

  obs.subscribe(data  => {
    this.users = data 
    console.log(this.users)
  })
  }

  toDelete(username: string)
  {
    let obs = this.http.get("http://localhost:8080/superadmin/deleteUser?username="+username)

  obs.subscribe(data  => {
    console.log(data)
  })
  obs = this.http.get("http://localhost:8080/superadmin/dashboard")

  obs.subscribe(data  => {
    this.users = data 
    console.log(this.users)
  })
  
  }

}
