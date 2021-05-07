import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-superadmin-navbar',
  templateUrl: './superadmin-navbar.component.html',
  styleUrls: ['./superadmin-navbar.component.css']
})
export class SuperadminNavbarComponent implements OnInit {

  constructor(private http:HttpClient, public loginService: AuthenticationService) { }

  ngOnInit(): void {
  }

}
