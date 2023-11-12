package anas.commerce.cartservice.services;

import anas.commerce.cartservice.contracts.repositories.ICartRepository;
import anas.commerce.cartservice.contracts.IGetCartByUSerIdService;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.mappers.CartMapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class GetCartByUSerIdService implements IGetCartByUSerIdService {

    private final Logger logger = Logger.getLogger(GetCartByUSerIdService.class.getName());

    @Autowired
    private ICartRepository repository;


    @Override
    public CartDto getCartByUserId(ObjectId id) throws Exception {
        Optional<CartEntity> cartOpt = repository.findById(id);
        if(cartOpt.isPresent()) {
            return CartMapper.transformerToDto(cartOpt.get());
        }

        throw new RuntimeException("Invalid cart ID : " + id);
    }

}
