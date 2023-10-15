package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.dtos.ItemDTO;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.services.AddItemToCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.logging.Logger;

@RestController
public class AddItemToCartController {


    private final Logger logger = Logger.getLogger(AddItemToCartController.class.getName());
    @Autowired
    private AddItemToCartService addItemToCartService;

    @PostMapping("carts/additem/{cartId}")
    public CartDto addItem(@PathVariable("cartId") String cartId, @RequestBody ItemDTO itemDTO){
        BigInteger cartIdParameter = new BigInteger(cartId);
        try {
            return addItemToCartService.addItem(cartIdParameter, itemDTO);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
