package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.services.GetCartByUSerIdService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class GetCartByUSerIdController {

    private final Logger logger = Logger.getLogger(GetCartByUSerIdController.class.getName());
    @Autowired
    private GetCartByUSerIdService getCartByUserIdService;

    @GetMapping("carts/getcartby/{id}")
    public CartDto getCartById(@PathVariable("id") String cartId){
        ObjectId cartIdParameter = new ObjectId(cartId);
        try {
            return getCartByUserIdService.getCartByUserId(cartIdParameter);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
