package anas.ecommerce.userservice.controllers;

import anas.ecommerce.userservice.contracts.IRegisterNewUserService;
import anas.ecommerce.userservice.dtos.UserDto;
import anas.ecommerce.userservice.exceptions.UserAlreadyExistException;
import anas.ecommerce.userservice.middlewares.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
@RestController
public class RegisterNewUserController {

    private final Logger logger = Logger.getLogger(RegisterNewUserController.class.getName());

    @Autowired
    private IRegisterNewUserService registerNewUserService;

    @ExceptionHandler(UserAlreadyExistException.class)
    @PostMapping("users/register-user")
    public ResponseEntity<Object> registerUser(@RequestBody @Validated UserDto userDto) {
        try {
            return new ResponseEntity<>(registerNewUserService.registerUser(userDto), HttpStatus.CREATED);
        }
        catch (RuntimeException ex){
            if(ex instanceof UserAlreadyExistException userAlreadyExistException){
                return new ResponseEntity<>(
                        new ErrorResponse("User already exist with that email: " + userAlreadyExistException.getEmail() + " and that phoneNumber: " + userAlreadyExistException.getPhoneNumber()),
                        HttpStatus.CONFLICT);
            }
            throw (ex);
        }
        finally {
            logger.log(Level.ALL, "registerUser ended !");
        }
    }

}
