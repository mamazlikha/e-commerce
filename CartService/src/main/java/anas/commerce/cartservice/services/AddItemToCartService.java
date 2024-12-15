package anas.commerce.cartservice.services;

import anas.commerce.cartservice.contracts.IAddItemToCartService;
import anas.commerce.cartservice.contracts.repositories.ICartRepository;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.dtos.ItemDTO;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.exceptions.ProductServiceIsInvalidException;
import anas.commerce.cartservice.mappers.ICartMapper;
import anas.commerce.cartservice.mappers.IItemMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class AddItemToCartService implements IAddItemToCartService {

    private final RestTemplate restTemplate;

    private final ICartRepository repository;

    private final ICartMapper cartMapper;

    private final IItemMapper itemMapper;

    @Value("${itemservice.host}")
    private String itemServiceUrl;

    @Autowired
    public AddItemToCartService(RestTemplateBuilder builder, ICartRepository repository, IItemMapper itemMapper, ICartMapper cartMapper){
        restTemplate = builder.build();
        this.itemMapper = itemMapper;
        this.cartMapper = cartMapper;
        this.repository = repository;
    }

    public CartDto addItem(ObjectId cartId, String itemId) throws RuntimeException {
        Optional<CartEntity> cartOpt = repository.findById(cartId);
        if(cartOpt.isPresent()) {
            CartEntity cart = cartOpt.get();
            var response = restTemplate.getForEntity(itemServiceUrl+"/items/"+itemId, ItemDTO.class); /// TODO replace with a client !
            if (response.getStatusCode() == HttpStatus.OK) {

                cart.getItems().add(itemMapper.itemDtoToItemEntity(Objects.requireNonNull(response.getBody())));

                return cartMapper.cartEntityToCartDto(repository.save(cart));
            }
            throw new ProductServiceIsInvalidException("ItemService is down !");
        }
        else {
            throw new RuntimeException("Invalid cart ID : " + cartId);
        }
    }
}
