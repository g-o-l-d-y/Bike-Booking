import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  email:any
  username:any
  password:any
  mobileNumber:any
  userRole:any
  age:any
  
  constructor(private router: Router,private httpClient:HttpClient) { }

  ngOnInit(): void {
  }

  signUp():boolean{
    let formData={
    'email': this.email, 
    'username':this.username,
    'password': this.password,
    'mobileNumber': this.mobileNumber,
    'userRole': this.userRole, 
    'age':this.age
    }
    console.log(this.email);
    console.log(formData)
    console.log(sessionStorage.getItem('username'))
    let obs=this.httpClient.post("http://localhost:8080/user/signup",formData);
    obs.subscribe((response) => {console.log(response)})
    this.router.navigate(['/login'])
    return true;
  }
}
