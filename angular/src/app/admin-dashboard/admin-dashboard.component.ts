import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  bikes : any 
  constructor(private router:Router, private http:HttpClient) {

   }

  ngOnInit(): void {
    console.log(sessionStorage.getItem('token'))
    let obs = this.http.get("http://localhost:8080/admin/dashboard?admin="+sessionStorage.getItem('username'))

  obs.subscribe(data  => {
    this.bikes = data 
    console.log(this.bikes)
  })
}

toEdit(bikeId:number){
    this.router.navigate(['/editBike'],{
      state:{
        bikeId:bikeId
      }
    })
}

toDelete(bikeId:number){
    let obs=this.http.get("http://localhost:8080/admin/deleteBike?bikeId="+bikeId);
    obs.subscribe(data  => {
      console.log(data)
    })
}

}
