package anas.commerce.items.contracts;

import anas.commerce.items.dtos.ProductDTO;

public interface IEditProductService {

    ProductDTO editProduct(ProductDTO newProductDto) throws RuntimeException;
}
