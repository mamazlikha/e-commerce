package anas.commerce.inventoryservice.exceptions;

public class ItemNotFoundException extends RuntimeException {

    private final String message;

    public ItemNotFoundException(String s) {
        message = s;
    }
}
