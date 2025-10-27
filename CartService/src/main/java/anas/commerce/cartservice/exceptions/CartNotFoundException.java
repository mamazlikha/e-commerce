package anas.commerce.cartservice.exceptions;

import lombok.Getter;
import org.bson.types.ObjectId;

@Getter
public class CartNotFoundException extends RuntimeException {

    private final String message;
    private final ObjectId id;
    public CartNotFoundException(String s, ObjectId id) {
        this.message = s;
        this.id = id;
    }
}
