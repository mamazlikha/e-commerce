import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FindAllProductsControllerService, ProductDTO } from 'e-commerce-product-client';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
  standalone   : true,
  imports      : [ NgFor],
})
export class ProductsComponent implements OnInit {

  public products : Array<ProductDTO> = [];

  constructor(private readonly findAllProductsControllerService: FindAllProductsControllerService){
  }

  ngOnInit() : void {

    this.findAllProductsControllerService.getAllItems().subscribe((items : Array<ProductDTO>) => {
      items.forEach(item => this.products.push(item));
    });
  }

}
