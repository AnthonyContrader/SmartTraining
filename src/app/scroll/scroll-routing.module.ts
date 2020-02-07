import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ScrollComponent } from './scroll.component';
import { LayoutScrollComponent } from '../layout/layout-scroll/layout-scroll.component';

const routes: Routes = [
  {
    path: 'scroll', component: LayoutScrollComponent, children: [
      {
        path: '', component: ScrollComponent
      }
    ]
      
  }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class ScrollRoutingModule { }