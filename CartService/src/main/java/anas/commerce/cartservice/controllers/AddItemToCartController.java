package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.services.AddItemToCartService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.logging.Logger;

@RestController
public class AddItemToCartController {


    private final Logger logger = Logger.getLogger(AddItemToCartController.class.getName());
    @Autowired
    private AddItemToCartService addItemToCartService;

    @PostMapping("carts/additem/{cartId}/{itemId}")
    public ResponseEntity<CartDto> addItem(@PathVariable("cartId") String cartId, @PathVariable String itemId){
        ObjectId cartIdParameter = new ObjectId(cartId);
        try {
            return new ResponseEntity<>(addItemToCartService.addItem(cartIdParameter, itemId), HttpStatus.CREATED);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
