package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.contracts.ICreateCartForUserService;
import anas.commerce.cartservice.dtos.CartDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequiredArgsConstructor
public class CreateCartForUserController {

    private final ICreateCartForUserService createCartForUserService;

    @PostMapping("carts/createforuser/")
    public ResponseEntity<CartDto> createCartForUser(){
        return new ResponseEntity<>(createCartForUserService.createNewCart(), HttpStatus.CREATED);
    }


}
