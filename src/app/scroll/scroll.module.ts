import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ScrollComponent } from './scroll.component';
import { ScrollRoutingModule } from './scroll-routing.module';

@NgModule({
  declarations: [ScrollComponent],
  imports: [
    CommonModule, ScrollRoutingModule, 
  ]
})
export class ScrollModule { }
