package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.services.CreateCartForUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.logging.Logger;


@RestController
public class CreateCartForUserController {


    private final Logger logger = Logger.getLogger(CreateCartForUserController.class.getName());
    @Autowired
    private CreateCartForUserService createCartForUserService;

    @PostMapping("carts/createforuser/")
    public ResponseEntity<CartDto> createCartForUser(){
        return new ResponseEntity<>(createCartForUserService.createNewCart(), HttpStatus.CREATED);
    }


}
