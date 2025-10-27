import { NgModule } from '@angular/core';

import { AppRoutingModule } from '../app-routing.module';
import { AppComponent } from '../app.component';
import { TranslateModule } from '@ngx-translate/core';
import { HttpClientModule } from '@angular/common/http';

import { ApiModule as ProductClientModule, Configuration as ProductConfig } from '@mamazlikha/e-commerce-product-client-typescript/dist/e-commerce-product-client-typescript';
import { ApiModule as UserClientModule, Configuration as UserConfig } from '@mamazlikha/e-commerce-user-client-typescript/dist/e-commerce-user-client-typescript';
import { ApiModule as CartClientModule } from '@mamazlikha/e-commerce-cart-client-typescript/dist/e-commerce-cart-client-typescript';
import { Configuration as CartConfiguration } from '@mamazlikha/e-commerce-cart-client-typescript/dist/e-commerce-cart-client-typescript';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    AppRoutingModule,
    HttpClientModule,
    TranslateModule,
    ProductClientModule.forRoot(() =>new ProductConfig({ basePath: 'http://localhost:8089' })),
    UserClientModule.forRoot(() => new UserConfig({ basePath: 'http://localhost:8089' })),
    CartClientModule.forRoot(() => {
      const config = new CartConfiguration({ basePath: 'http://localhost:8082' });
      config.selectHeaderAccept = () => 'application/json'; 
      return config;
    }),
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class SharedModule { }
