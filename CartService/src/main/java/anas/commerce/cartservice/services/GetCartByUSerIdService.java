package anas.commerce.cartservice.services;

import anas.commerce.cartservice.contracts.IGetCartByUSerIdService;
import anas.commerce.cartservice.contracts.repositories.ICartRepository;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.exceptions.CartNotFoundException;
import anas.commerce.cartservice.mappers.ICartMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class GetCartByUSerIdService implements IGetCartByUSerIdService {

    private final ICartMapper cartMapper;

    private final ICartRepository repository;

    @Override
    public CartDto getCartByUserId(ObjectId id) throws RuntimeException {
        Optional<CartEntity> cartOpt = repository.findById(id);
        if(cartOpt.isPresent()) {
            return cartMapper.cartEntityToCartDto(cartOpt.get());
        }

        throw new CartNotFoundException("Invalid cart ID : " + id);
    }

}
