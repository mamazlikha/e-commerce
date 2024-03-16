package anas.commerce.items.contracts;

import anas.commerce.items.dtos.EditProductDto;

public interface IEditProductService {

    /**
     *
     * */
    EditProductDto editProduct(EditProductDto newProductDto) throws RuntimeException;
}
