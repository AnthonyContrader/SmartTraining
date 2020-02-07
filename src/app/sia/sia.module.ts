import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SiaHomeComponent } from './sia-home/sia-home.component';
import { SiaSearchComponent } from './sia-search/sia-search.component';
import { SiaRoutingModule } from './sia-routing.module';
import { SiaLayoutComponent } from '../layout/sia-layout/sia-layout.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [SiaHomeComponent,SiaSearchComponent],
  imports: [
    CommonModule,
    SiaRoutingModule,
    FormsModule
  ]
})
export class SiaModule { }
