package anas.ecommerce.userservice.controllers;

import anas.ecommerce.userservice.contracts.IUpdateUserService;
import anas.ecommerce.userservice.dtos.userdto.EditUserDto;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import anas.ecommerce.userservice.mappers.EditUserMapper;
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


    @ExceptionHandler(RuntimeException.class)
    @PutMapping("users/update-user/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody @Validated EditUserDto editUserDto, @PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(updateUserService.updateUserById(editUserDto, new ObjectId(id)), HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            logger.log(Level.ALL, "updateUser ended !");
        }
    }
}
