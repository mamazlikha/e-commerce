package anas.commerce.cartservice.exceptions;

import lombok.Getter;

@Getter
public class ProductServiceIsInvalidException extends RuntimeException {

    private final String message;

    public ProductServiceIsInvalidException(String msg){
        this.message = msg;

    }
}
