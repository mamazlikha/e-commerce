package anas.commerce.cartservice.controllers;

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

    @PostMapping("carts/additem/{userId}")
    public CartEntity addItem(@PathVariable("userId") String userId, @RequestBody ItemDTO itemDTO){
        BigInteger userIdParameter = new BigInteger(userId);
        try {
            return addItemToCartService.addItem(userIdParameter, itemDTO);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
