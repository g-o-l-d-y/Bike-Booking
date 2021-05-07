import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bookings',
  templateUrl: './bookings.component.html',
  styleUrls: ['./bookings.component.css']
})
export class BookingsComponent implements OnInit {
  bikes:any
  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
    let obs=this.http.get("http://localhost:8080/user/bookings?user="+sessionStorage.getItem('username'))

    obs.subscribe(data  => {
      this.bikes = data 
      console.log(this.bikes)
    })
  }

}
