package anas.commerce.cartservice.services;

import anas.commerce.cartservice.contracts.repositories.ICartRepository;
import anas.commerce.cartservice.contracts.IRemoveItemFromCartService;
import anas.commerce.cartservice.entities.CartEntity;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RemoveItemFromCartService implements IRemoveItemFromCartService {

    private final Logger logger = Logger.getLogger(RemoveItemFromCartService.class.getName());

    @Autowired
    private ICartRepository repository;

    @Override
    public boolean removeItem(ObjectId cartId, ObjectId itemId) {

        Optional<CartEntity> cartOpt = repository.findById(cartId);

        if(cartOpt.isPresent()) {
            CartEntity cart = cartOpt.get();

            return cart.getItems().removeIf(x -> x.getId().equals(itemId));
        }
        return false;
    }
}
