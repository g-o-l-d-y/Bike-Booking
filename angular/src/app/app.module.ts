import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminNavbarComponent } from './admin-navbar/admin-navbar.component';
import { BasicAuthHttpInterceptorService } from './services/basic-auth-http-interceptor.service';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { AddBikeComponent } from './add-bike/add-bike.component';
import { EditBikeComponent } from './edit-bike/edit-bike.component';
import { SignupComponent } from './signup/signup.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserNavbarComponent } from './user-navbar/user-navbar.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { BookingsComponent } from './bookings/bookings.component';
import { SuperadminDashboardComponent } from './superadmin-dashboard/superadmin-dashboard.component';
import { SuperadminNavbarComponent } from './superadmin-navbar/superadmin-navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminDashboardComponent,
    AdminNavbarComponent,
    AdminProfileComponent,
    AddBikeComponent,
    EditBikeComponent,
    SignupComponent,
    UserDashboardComponent,
    UserNavbarComponent,
    UserProfileComponent,
    BookingsComponent,
    SuperadminDashboardComponent,
    SuperadminNavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: BasicAuthHttpInterceptorService, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
