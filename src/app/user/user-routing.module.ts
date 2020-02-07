import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LoginLayoutComponent } from '../layout/login-layout/login-layout.component';


const routesRoot: Routes = [
  {path: 'user', component: LoginLayoutComponent, children: [ //login e login component
    {path: '', component: LoginComponent},
    
  ]}
];
@NgModule({
  imports: [RouterModule.forChild(routesRoot)], //forChild
  exports: [RouterModule]
})
export class UserRoutingModule { }


