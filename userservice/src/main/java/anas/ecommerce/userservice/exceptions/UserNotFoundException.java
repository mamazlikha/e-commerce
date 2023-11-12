package anas.ecommerce.userservice.exceptions;

import lombok.Getter;
import org.bson.types.ObjectId;

@Getter
public class UserNotFoundException extends RuntimeException {

    private final ObjectId userId;

    public UserNotFoundException(ObjectId id) {
        userId = id;
    }
}
