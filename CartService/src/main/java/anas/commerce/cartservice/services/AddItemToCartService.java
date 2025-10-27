package anas.commerce.cartservice.services;

import anas.commerce.cartservice.contracts.IAddItemToCartService;
import anas.commerce.cartservice.contracts.repositories.ICartRepository;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.dtos.ItemDTO;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.exceptions.CartNotFoundException;
import anas.commerce.cartservice.exceptions.ProductServiceIsInvalidException;
import anas.commerce.cartservice.mappers.ICartMapper;
import anas.commerce.cartservice.mappers.IItemMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
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

    @Setter
    private RestTemplate restTemplate;

    @Setter
    private ICartRepository repository;

    private final ICartMapper cartMapper;

    private final IItemMapper itemMapper;

    @Value("${inventoryservice.port}")
    private String inventoryServicePort;

    @Value("${inventoryservice.host}")
    private String inventoryServiceUrl;

    @Autowired
    public AddItemToCartService(RestTemplateBuilder builder, ICartRepository repository, IItemMapper itemMapper, ICartMapper cartMapper){
        restTemplate = builder.build();
        this.itemMapper = itemMapper;
        this.cartMapper = cartMapper;
        this.repository = repository;
    }

    public CartDto addItem(ObjectId cartId, String productEntityId) throws RuntimeException {
        Optional<CartEntity> cartOpt = repository.findById(cartId);
        if(cartOpt.isPresent()) {
            CartEntity cart = cartOpt.get();
            var response = restTemplate.getForEntity(inventoryServiceUrl +":" + inventoryServicePort +"/items/"+productEntityId, ItemDTO.class); // TODO replace with a client !
            if (response.getStatusCode() == HttpStatus.OK) {

                cart.getItems().add(itemMapper.itemDtoToItemEntity(Objects.requireNonNull(response.getBody())));
                CartEntity itemInCart = repository.save(cart);
                CartDto result = cartMapper.cartEntityToCartDto(itemInCart);
                result.setItemsDto(itemMapper.itemEntitiesToItemsDto(itemInCart.getItems()));
                return result;
            }
            throw new ProductServiceIsInvalidException("ItemService is down !");
        }
        else {
            throw new CartNotFoundException("Invalid cart ID : " + cartId, cartId);
        }
    }
}
