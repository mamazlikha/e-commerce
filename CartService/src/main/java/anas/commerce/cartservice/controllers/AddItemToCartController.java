package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.services.AddItemToCartService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class AddItemToCartController {


    private final Logger logger = Logger.getLogger(AddItemToCartController.class.getName());
    @Autowired
    private AddItemToCartService addItemToCartService;

    @PostMapping("carts/additem/{cartId}/{itemId}")
    public CartDto addItem(@PathVariable("cartId") String cartId, @PathVariable String itemId){
        ObjectId cartIdParameter = new ObjectId(cartId);
        try {
            return addItemToCartService.addItem(cartIdParameter, itemId);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
