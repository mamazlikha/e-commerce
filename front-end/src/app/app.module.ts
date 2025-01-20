import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
  ],
  imports: [
    BrowserModule,
    CommonModule,
    SharedModule,
  ],
  providers: [],
  bootstrap: [AppComponent],

})
export class AppModule { }
