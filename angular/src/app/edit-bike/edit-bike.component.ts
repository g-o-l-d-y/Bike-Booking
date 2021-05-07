import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-bike',
  templateUrl: './edit-bike.component.html',
  styleUrls: ['./edit-bike.component.css']
})
export class EditBikeComponent implements OnInit {

  bikeId:any
  admin:any
  bikeNo:any
  status:any
  price:any
  
  bikeData:any
  constructor(private router:Router,private http:HttpClient) { }

  ngOnInit(): void {
    let temp:any=history.state
    console.log(temp)
    let obs = this.http.get("http://localhost:8080/user/bikeDetails?bikeId="+temp.bikeId);

    obs.subscribe(data  => {
      this.bikeData=data
      this.bikeId=this.bikeData.bikeId
      this.admin=this.bikeData.admin
      this.bikeNo=this.bikeData.bikeNo
      this.status=this.bikeData.status
      this.price=this.bikeData.price
      console.log(data)
    })
  }

  editBike(){
    let formData={
      'bikeId':this.bikeId,
      'admin':this.admin,
      'bikeNo':this.bikeNo,
      'status':this.status,
      'price':this.price,
    }
    console.log(formData)
    let obs=this.http.post("http://localhost:8080/admin/editBike",formData);
    obs.subscribe((response) => {console.log(response)})
    this.router.navigate(['/adminDashboard'])
  }

}
