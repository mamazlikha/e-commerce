package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.contracts.IGetCartByUSerIdService;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.exceptions.CartNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class GetCartByUSerIdController {

    private final Logger logger = Logger.getLogger(GetCartByUSerIdController.class.getName());
    @Autowired
    private IGetCartByUSerIdService getCartByUserIdService;

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
