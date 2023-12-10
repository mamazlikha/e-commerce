package anas.commerce.cartservice.services;

import anas.commerce.cartservice.contracts.IAddItemToCartService;
import anas.commerce.cartservice.contracts.repositories.ICartRepository;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.dtos.ItemDTO;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.exceptions.ProductServiceIsInvalidException;
import anas.commerce.cartservice.mappers.CartMapper;
import anas.commerce.cartservice.mappers.ItemMapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AddItemToCartService implements IAddItemToCartService {

    private final Logger logger = Logger.getLogger(AddItemToCartService.class.getName());

    private final RestTemplate restTemplate;

    @Autowired
    private ICartRepository repository;

    @Value("${itemservice.host}")
    private String itemServiceUrl;

    @Autowired
    public AddItemToCartService(RestTemplateBuilder builder){
        restTemplate = builder.build();
    }

    public CartDto addItem(ObjectId cartId, String itemId) throws RuntimeException {
        Optional<CartEntity> cartOpt = repository.findById(cartId);
        if(cartOpt.isPresent()) {
            CartEntity cart = cartOpt.get();
            var response = restTemplate.getForEntity(itemServiceUrl+"/items/"+itemId, ItemDTO.class); /// TODO replace with a client !
            if (response.getStatusCode() == HttpStatus.OK) {

                cart.getItems().add(ItemMapper.transformerToEntity(Objects.requireNonNull(response.getBody())));

                return CartMapper.transformerToDto(repository.save(cart));
            }
            throw new ProductServiceIsInvalidException("ItemService is down !");
        }
        else {
            throw new RuntimeException("Invalid cart ID : " + cartId);
        }
    }
}
