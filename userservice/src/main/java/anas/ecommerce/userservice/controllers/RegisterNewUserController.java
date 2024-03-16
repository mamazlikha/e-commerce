package anas.ecommerce.userservice.controllers;

import anas.ecommerce.userservice.contracts.IRegisterNewUserService;
import anas.ecommerce.userservice.dtos.userdto.CreateUserDto;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import anas.ecommerce.userservice.exceptions.UserAlreadyExistException;
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
    public ResponseEntity<CreateUserDto> registerUser(@RequestBody @Validated CreateUserDto createUserDto) {
        logger.log(Level.ALL, "Adding new user ...");
        try {
            return new ResponseEntity<>(registerNewUserService.registerUser(createUserDto), HttpStatus.CREATED);
        } catch (UserAlreadyExistException ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            logger.log(Level.ALL, "registerUser ended !");
        }
    }

}
