package anas.commerce.items.contracts;

import anas.commerce.items.dtos.CreateProductDto;
import anas.commerce.items.dtos.ProductDTO;

public interface IAddNewProductService {


    /**
     * @param createProductDTO new product to add
     * @exception RuntimeException if a product with same supplier number already exist
     * @return ProductDTO
     */
    ProductDTO addNewProduct(CreateProductDto createProductDTO) throws RuntimeException;
}
