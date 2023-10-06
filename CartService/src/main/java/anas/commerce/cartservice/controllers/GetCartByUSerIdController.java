package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.services.GetCartByUSerIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.logging.Logger;

@RestController("carts")
public class GetCartByUSerIdController {

    private final Logger logger = Logger.getLogger(GetCartByUSerIdController.class.getName());
    @Autowired
    private GetCartByUSerIdService getCartByUserIdService;

    @GetMapping("/getcartby/{userId}")
    public CartEntity getUserCart(@PathVariable("userId") String userId){
        BigInteger userIdParameter = new BigInteger(userId);
        try {
            return getCartByUserIdService.userCart(userIdParameter);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}