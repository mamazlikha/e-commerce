package anas.commerce.cartservice.services;

import anas.commerce.cartservice.contracts.repositories.ICartRepository;
import anas.commerce.cartservice.contracts.ICreateCartForUserService;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.mappers.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.logging.Logger;

@Service
public class CreateCartForUserService implements ICreateCartForUserService {


    private final Logger logger = Logger.getLogger(CreateCartForUserService.class.getName());

    @Autowired
    private ICartRepository repository;

    @Override
    public CartDto createNewCart() {
        CartEntity cart = new CartEntity(new HashSet<>(), 0);
        return CartMapper.transformerToDto(repository.save(cart));
    }
}
