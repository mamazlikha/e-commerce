package anas.commerce.inventoryservice.exceptions;

import org.bson.types.ObjectId;

public class EmptyItemsForProductException extends RuntimeException {
    private final String message;
    private final ObjectId id;
    public EmptyItemsForProductException(String s, ObjectId id) {
        message = s;
        this.id = id;
    }

}
