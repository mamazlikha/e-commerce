package anas.commerce.cartservice.services;

import anas.commerce.cartservice.contracts.ICartRepository;
import anas.commerce.cartservice.contracts.IGetCartByUSerIdService;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.mappers.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class GetCartByUSerIdService implements IGetCartByUSerIdService {


    @Autowired
    private ICartRepository repository;


    public CartDto userCart(BigInteger userId) throws Exception {
        Optional<CartEntity> cartOpt = repository.findById(userId);
        if(cartOpt.isPresent()) {
            return CartMapper.transformerToDto(cartOpt.get());
        }

        throw new RuntimeException("Invalid user ID : " + userId);
    }

}
