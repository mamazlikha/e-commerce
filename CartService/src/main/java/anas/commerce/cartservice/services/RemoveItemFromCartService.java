package anas.commerce.cartservice.services;

import anas.commerce.cartservice.contracts.ICartRepository;
import anas.commerce.cartservice.contracts.IRemoveItemFromCartService;
import anas.commerce.cartservice.entities.CartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class RemoveItemFromCartService implements IRemoveItemFromCartService {


    @Autowired
    private ICartRepository repository;

    @Override
    public boolean removeItem(BigInteger cartId, BigInteger itemId) {

        Optional<CartEntity> cartOpt = repository.findById(cartId);

        if(cartOpt.isPresent()) {
            CartEntity cart = cartOpt.get();

            return cart.getItems().removeIf(x -> x.getId().equals(itemId));
        }
        return false;
    }
}
