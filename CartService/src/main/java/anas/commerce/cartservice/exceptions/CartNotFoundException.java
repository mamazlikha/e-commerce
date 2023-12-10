package anas.commerce.cartservice.exceptions;

import lombok.Getter;

@Getter
public class CartNotFoundException extends RuntimeException {

    private final String message;
    public CartNotFoundException(String s) {
        this.message = s;
    }
}
