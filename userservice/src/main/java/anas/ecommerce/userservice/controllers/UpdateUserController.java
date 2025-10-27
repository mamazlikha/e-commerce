package anas.ecommerce.userservice.controllers;

import anas.ecommerce.userservice.contracts.IUpdateUserService;
import anas.ecommerce.userservice.dtos.userdto.EditUserDto;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;

@RestController
@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/users")
public class UpdateUserController {

    private final IUpdateUserService updateUserService;


    @ExceptionHandler(RuntimeException.class)
    @PutMapping(value = "/update-user/{id}", produces="application/json")
    public ResponseEntity<UserDto> updateUser(@RequestBody @Validated EditUserDto editUserDto, @PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(updateUserService.updateUserById(editUserDto, new ObjectId(id)), HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            log.info("updateUser ended !");
        }
    }
}
