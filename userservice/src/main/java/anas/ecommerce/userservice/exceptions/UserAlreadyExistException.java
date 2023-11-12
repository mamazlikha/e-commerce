package anas.ecommerce.userservice.exceptions;

import lombok.Getter;

@Getter
public class UserAlreadyExistException extends RuntimeException {

    private final String email;
    private final String phoneNumber;
    public UserAlreadyExistException(String email, String phoneNumber){
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
