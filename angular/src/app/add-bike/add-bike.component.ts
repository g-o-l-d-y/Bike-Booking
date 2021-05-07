import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-bike',
  templateUrl: './add-bike.component.html',
  styleUrls: ['./add-bike.component.css']
})
export class AddBikeComponent implements OnInit {
  bikeID:any
  admin:any
  bikeNo:any
  status:any
  price:any
  
  constructor(private router:Router,private http:HttpClient) { }

  ngOnInit(): void {
  }

  addBike(){
      let formData={
        'admin':sessionStorage.getItem('username'),
        'bikeNo':this.bikeNo,
        'status':"notBooked",
        'price':this.price,
      }
      let obs=this.http.post("http://localhost:8080/admin/addBike",formData);
    obs.subscribe((response) => {console.log(response)})
    this.router.navigate(['/adminDashboard'])
  }

}
