package anas.ecommerce.userservice.controllers;

import anas.ecommerce.userservice.contracts.IRegisterNewUserService;
import anas.ecommerce.userservice.dtos.UserDto;
import anas.ecommerce.userservice.exceptions.UserAlreadyExistException;
import anas.ecommerce.userservice.exceptions.UserNotCreatedException;
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

    @ExceptionHandler(RuntimeException.class)
    @PostMapping("users/register-user")
    public ResponseEntity<UserDto> registerUser(@RequestBody @Validated UserDto userDto) {
        try {
            return new ResponseEntity<>(registerNewUserService.registerUser(userDto), HttpStatus.CREATED);
        } catch (UserAlreadyExistException ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            logger.log(Level.ALL, "registerUser ended !");
        }
    }

}
