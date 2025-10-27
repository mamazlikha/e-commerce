import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { GetCartByUSerIdControllerService } from '@mamazlikha/e-commerce-cart-client-typescript/dist/e-commerce-cart-client-typescript';
import { CreateCartForUserControllerService } from '@mamazlikha/e-commerce-cart-client-typescript/dist/e-commerce-cart-client-typescript';
import { FindAllProductsControllerService, GetProductByIdControllerService } from '@mamazlikha/e-commerce-product-client-typescript/dist/e-commerce-product-client-typescript';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
  standalone   : true,
  imports      : [ NgFor],
})
export class ProductsComponent implements OnInit {

  public products : Array<any> = [];

  constructor(private getProductByIdControllerService: GetProductByIdControllerService,
    private readonly findAllProductsControllerService: FindAllProductsControllerService,
     private getCartByUserIdControllerService: GetCartByUSerIdControllerService, private createCartForUserControllerService: CreateCartForUserControllerService){
  }

  ngOnInit() : void {
    this.getCartByUserIdControllerService.getCartById('653e9af7782d206ae4af64b1').subscribe((value) => {
      console.log('value.id = ', value.id);
      console.log('value.itemsDto = ', value.itemsDto);
      console.log('value.totalPrice = ', value.totalPrice);
    });
    
    this.getProductByIdControllerService.getProductById('66c21ad2ae32a96d9ba449d2').subscribe(value => {
      console.log('value = ', value);
    });

    this.findAllProductsControllerService.getAllItems().subscribe(values => {
      console.log('values = ', values);
    })
  }

}
