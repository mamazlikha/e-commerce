package anas.commerce.cartservice.services;

import anas.commerce.cartservice.contracts.IRemoveItemFromCartService;
import anas.commerce.cartservice.contracts.repositories.ICartRepository;
import anas.commerce.cartservice.entities.CartEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RemoveItemFromCartService implements IRemoveItemFromCartService {


    private final ICartRepository repository;

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
