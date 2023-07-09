package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.services.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.logging.Logger;

@RestController
public class CartsController {

    private final Logger logger = Logger.getLogger(CartsController.class.getName());
    @Autowired
    private CartsService cartsService;

    @GetMapping("/cart/{userId}")
    public CartEntity getUserCart(@PathVariable("userId") String userId){
        BigInteger userIdParameter = new BigInteger(userId);
        try {
            return cartsService.userCart(userIdParameter);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
