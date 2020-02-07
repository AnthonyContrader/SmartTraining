import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { SiaLayoutComponent } from './sia-layout/sia-layout.component';
import { RouterModule } from '@angular/router';
import { LoginLayoutComponent } from './login-layout/login-layout.component';
import { HeaderLoginComponent } from './header-login/header-login.component';
import { SiaSearchLayoutComponent } from './sia-search-layout/sia-search-layout.component';
import { LayoutScrollComponent } from './layout-scroll/layout-scroll.component';

@NgModule({
  declarations: [HeaderComponent, SiaLayoutComponent, LoginLayoutComponent, HeaderLoginComponent, SiaSearchLayoutComponent, LayoutScrollComponent ],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class LayoutModule { }
