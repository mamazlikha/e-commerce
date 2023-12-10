package anas.ecommerce.userservice.controllers;

import anas.ecommerce.userservice.contracts.IGetUserByIdService;
import anas.ecommerce.userservice.dtos.UserDto;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import anas.ecommerce.userservice.middlewares.ErrorResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class GetUserByIdController {

    private final Logger logger = Logger.getLogger(GetUserByIdController.class.getName());


    @Autowired
    private IGetUserByIdService getUserByIdService;

    @GetMapping("users/{id}")
    public ResponseEntity<UserDto> getUSerById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(getUserByIdService.getUserById(new ObjectId(id)), HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {

        }
    }
}
