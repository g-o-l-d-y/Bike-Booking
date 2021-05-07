import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBikeComponent } from './add-bike/add-bike.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { BookingsComponent } from './bookings/bookings.component';
import { EditBikeComponent } from './edit-bike/edit-bike.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { SuperadminDashboardComponent } from './superadmin-dashboard/superadmin-dashboard.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'adminDashboard', component: AdminDashboardComponent },
  { path: 'userDashboard', component: UserDashboardComponent },
  { path: 'superadminDashboard', component: SuperadminDashboardComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'adminProfile', component: AdminProfileComponent },
  { path: 'userProfile', component: UserProfileComponent },
  { path: 'addBike', component: AddBikeComponent },
  {path: 'editBike',component:EditBikeComponent},
  { path: 'bookings', component: BookingsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
