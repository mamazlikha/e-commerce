package anas.commerce.inventoryservice.exceptions;

import lombok.Getter;

@Getter
public class ItemNotFoundException extends RuntimeException {

    private final String id;
    private final String message;
    public ItemNotFoundException(String s, String id) {
        this.id = id;
        message = s;
    }
}
