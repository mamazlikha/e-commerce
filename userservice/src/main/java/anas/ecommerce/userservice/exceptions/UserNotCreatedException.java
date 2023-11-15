package anas.ecommerce.userservice.exceptions;

import lombok.Getter;

@Getter
public class UserNotCreatedException extends RuntimeException {

    private final String message;

    public UserNotCreatedException(String message){
        this.message = message;
    }

}
