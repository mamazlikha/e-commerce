package anas.commerce.cartservice.services;

import anas.commerce.cartservice.contracts.ICreateCartForUserService;
import anas.commerce.cartservice.contracts.repositories.ICartRepository;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.mappers.ICartMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@Slf4j
@AllArgsConstructor
public class CreateCartForUserService implements ICreateCartForUserService {

    private final ICartRepository repository;

    private final ICartMapper cartMapper;

    @Override
    public CartDto createNewCart() {
        CartEntity cart = repository.save(new CartEntity(new HashSet<>(), 0));
        return cartMapper.cartEntityToCartDto(cart);
    }
}
