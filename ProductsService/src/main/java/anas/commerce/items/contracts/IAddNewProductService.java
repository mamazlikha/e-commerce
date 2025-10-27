package anas.commerce.items.contracts;

import anas.commerce.items.dtos.CreateProductDto;

public interface IAddNewProductService {


    /**
     * @param createProductDTO new product to add
     * @exception RuntimeException if a product with same supplier number already exist
     * @return ProductDTO
     */
    CreateProductDto addNewProduct(CreateProductDto createProductDTO) throws RuntimeException;
}
