package anas.commerce.cartservice.services;

import anas.commerce.cartservice.contracts.ICartRepository;
import anas.commerce.cartservice.dtos.ItemDTO;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.mappers.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class AddItemToCartService {

    private final RestTemplate restTemplate;


    @Autowired
    private ICartRepository repository;

    @Value("${itemservice.host}")
    private String itemServiceUrl;

    @Autowired
    public AddItemToCartService(RestTemplateBuilder builder){
        restTemplate = builder.build();
    }

    public CartEntity addItem(BigInteger userId, ItemDTO itemDTO) throws Exception {
        Optional<CartEntity> cartOpt = repository.findById(userId);
        if(cartOpt.isPresent()) {
            CartEntity cart = cartOpt.get();

            cart.getItems().add(ItemsMapper.transformerToEntity(itemDTO));

            return cart;
        }

        throw new RuntimeException("Invalid user ID : " + userId);
    }
}
