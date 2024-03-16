package anas.commerce.items.exceptions;

public class ProductAlreadyExistException extends RuntimeException {

    private final String supplierNumber;
    public ProductAlreadyExistException(String supplierNumber){
        this.supplierNumber = supplierNumber;
    }
}
