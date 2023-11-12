package anas.ecommerce.userservice.controllers;

import anas.ecommerce.userservice.contracts.IUpdateUserService;
import anas.ecommerce.userservice.dtos.UserDto;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import anas.ecommerce.userservice.middlewares.ErrorResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@ControllerAdvice
public class UpdateUserController {

    private final Logger logger = Logger.getLogger(UpdateUserController.class.getName());

    @Autowired
    private IUpdateUserService updateUserService;


    @ExceptionHandler(UserNotFoundException.class)
    @PutMapping("users/update-user/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody @Validated UserDto userDto, @PathVariable("id") String id){
        try {
            return new ResponseEntity<>(updateUserService.updateUserById(userDto, new ObjectId(id)), HttpStatus.OK);
        } catch (RuntimeException ex) {
            if(ex instanceof UserNotFoundException userNotFoundException){
                return new ResponseEntity<>(new ErrorResponse("User not found: " + userNotFoundException.getUserId()), HttpStatus.NOT_FOUND);
            }
            throw (ex);
        }
        finally {
            logger.log(Level.ALL, "updateUser ended !");
        }
    }
}
