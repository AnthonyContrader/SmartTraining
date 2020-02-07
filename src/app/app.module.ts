import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { SiaModule } from './sia/sia.module';
import { LayoutModule } from './layout/layout.module';
import { UserModule } from './user/user.module';
import { ScrollModule } from './scroll/scroll.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    SiaModule,
    LayoutModule,
    UserModule,
    ScrollModule,
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
