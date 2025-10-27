package anas.commerce.items.contracts;

import anas.commerce.items.dtos.EditProductDto;

public interface IEditProductService {

    /**
     *
     * @param newProductDto
     * @return EditProductDto
     * @throws RuntimeException
     */
    EditProductDto editProduct(EditProductDto newProductDto) throws RuntimeException;
}
