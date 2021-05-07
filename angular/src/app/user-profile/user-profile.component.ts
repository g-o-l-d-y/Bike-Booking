import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  profile:any
  username:any
  email:any
  password:any
  mobileNumber:any
  userRole:any
  age:any


  constructor(private router: Router,private http:HttpClient) { }

  editProfile(){
    let formData={
      'email': this.email, 
      'password': this.password,
      'mobileNumber': this.mobileNumber,
      'userRole': this.userRole, 
      'age':this.age,
      'username':this.username
      }
      console.log(this.email);
      console.log(this.mobileNumber);
    console.log(formData);
    console.log(sessionStorage.getItem('username'))
    let obs=this.http.post("http://localhost:8080/user/editProfile",formData);
    obs.subscribe((response) => {console.log(response)})
    this.router.navigate(['/userDashboard'])
  }

  ngOnInit(): void {
    let obs = this.http.get("http://localhost:8080/user/profile?username="+sessionStorage.getItem('username'))
    obs.subscribe(data  => {
      this.profile = data 
      console.log(this.profile)
      this.email=this.profile.email
      this.password=this.profile.password
      this.mobileNumber=this.profile.mobileNumber
      this.userRole=this.profile.userRole
      this.age=this.profile.age
      this.username=this.profile.username
    })
  }

}
