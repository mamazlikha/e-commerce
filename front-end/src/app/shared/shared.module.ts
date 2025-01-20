import { NgModule } from '@angular/core';

import { AppRoutingModule } from '../app-routing.module';
import { AppComponent } from '../app.component';
import { TranslateModule } from '@ngx-translate/core';
import { ApiModule } from 'e-commerce-product-client';
import { HttpClientModule } from '@angular/common/http';
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    AppRoutingModule,
    HttpClientModule,
    TranslateModule,
    ApiModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class SharedModule { }
