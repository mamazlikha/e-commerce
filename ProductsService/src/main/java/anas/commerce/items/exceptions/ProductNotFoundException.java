package anas.commerce.items.exceptions;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends RuntimeException {
    private final String productId;

    public ProductNotFoundException(String s, String productId) {
        this.productId = productId;
    }
}
