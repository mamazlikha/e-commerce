package anas.commerce.cartservice.services;

import anas.commerce.cartservice.contracts.ICartRepository;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.mappers.ItemsMapper;
import anas.commerce.items.dtos.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class AddItemToCartService {


    @Autowired
    private ICartRepository repository;


    public CartEntity addItem(BigInteger userId, ItemDTO itemDTO) throws Exception {
        Optional<CartEntity> cartOpt = repository.findById(userId);
        if(cartOpt.isPresent()) {
            CartEntity cart = cartOpt.get();

            cart.getItems().add(ItemsMapper.transformer(itemDTO));

            return cart;
        }

        throw new RuntimeException("Invalid user ID : " + userId);
    }
}
