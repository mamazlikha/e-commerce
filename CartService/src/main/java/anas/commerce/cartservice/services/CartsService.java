package anas.commerce.cartservice.services;

import anas.commerce.cartservice.contracts.ICartRepository;
import anas.commerce.cartservice.entities.CartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class CartsService {


    @Autowired
    private ICartRepository repository;


    public CartEntity userCart(BigInteger userId) throws Exception {
        Optional<CartEntity> cartOpt = repository.findById(userId);
        if(cartOpt.isPresent()) {
            return cartOpt.get();
        }

        throw new RuntimeException("Invalid user ID : " + userId);
    }

}
