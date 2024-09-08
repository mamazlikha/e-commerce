package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.contracts.IGetCartByUSerIdService;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.exceptions.CartNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequiredArgsConstructor
public class GetCartByUSerIdController {

    private final IGetCartByUSerIdService getCartByUserIdService;

    @GetMapping("carts/getcartby/{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable("id") String cartId){
        try {
            return new ResponseEntity<>(getCartByUserIdService.getCartByUserId(new ObjectId(cartId)), HttpStatus.OK);
        }
        catch (CartNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
