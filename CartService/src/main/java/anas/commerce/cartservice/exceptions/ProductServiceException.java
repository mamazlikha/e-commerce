package anas.commerce.cartservice.exceptions;


import anas.ecommerce.client.ApiException;

public class ProductServiceException extends Exception {
    private final String message;
    public ProductServiceException(String errorCallingProductService, ApiException exception) {
        this.message = errorCallingProductService;
    }
}
