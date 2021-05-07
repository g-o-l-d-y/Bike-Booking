import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
  bikes:any
  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
    console.log(sessionStorage.getItem('token'))
    let obs = this.http.get("http://localhost:8080/user/dashboard")

    obs.subscribe(data  => {
    this.bikes = data 
    console.log(this.bikes)
  })
  }

  toBook(bikeId: number, admin: string)
  {
    console.log(bikeId)
    let obs = this.http.get("http://localhost:8080/user/bookBike?bikeId="+bikeId+"&user="+sessionStorage.getItem('username')+"&admin="+admin)
    obs.subscribe(data  => {
      console.log(data)
    })
  }

}
