package anas.commerce.items.exceptions;

import lombok.Getter;

public class ProductAlreadyExistException extends RuntimeException {

    @Getter
    private final String supplierNumber;
    public ProductAlreadyExistException(String supplierNumber){
        this.supplierNumber = supplierNumber;
    }
}
