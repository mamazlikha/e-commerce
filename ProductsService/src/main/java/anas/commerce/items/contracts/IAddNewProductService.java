package anas.commerce.items.contracts;

import anas.commerce.items.dtos.ProductDTO;

public interface IAddNewProductService {


    /**
     * @param productDTO new product to add
     * @return ProductDTO
     */
    ProductDTO addNewProduct(ProductDTO productDTO);
}
