import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { SiaHomeComponent } from './sia-home/sia-home.component';
import { SiaSearchComponent } from './sia-search/sia-search.component';
import { SiaLayoutComponent } from '../layout/sia-layout/sia-layout.component';
import { SiaSearchLayoutComponent } from '../layout/sia-search-layout/sia-search-layout.component';


const routesRoot: Routes = [
  {path: 'sia', component: SiaLayoutComponent, children: [ //login e login component
    {path: '', component: SiaHomeComponent},
    {path: 'sia-search', component: SiaSearchLayoutComponent, children: [
      {path: '', component: SiaSearchComponent}
    ]}
  ]}
];
@NgModule({
  imports: [RouterModule.forRoot(routesRoot)], //forChild
  exports: [RouterModule]
})
export class SiaRoutingModule { }
