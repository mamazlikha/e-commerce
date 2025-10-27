package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.contracts.IAddItemToCartService;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.exceptions.CartNotFoundException;
import anas.commerce.cartservice.exceptions.ProductServiceIsInvalidException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/carts")
public class AddItemToCartController {

    private final IAddItemToCartService addItemToCartService;

    @PostMapping("/additem/{cartId}/{productId}")
    public ResponseEntity<CartDto> addItem(@PathVariable("cartId") String cartId, @PathVariable String productId){
        ObjectId cartIdParameter = new ObjectId(cartId);
        try {
            return new ResponseEntity<>(addItemToCartService.addItem(cartIdParameter, productId), HttpStatus.CREATED);
        }
        catch (ProductServiceIsInvalidException e) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        catch (CartNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        finally {
            log.info("addItem method is finished !");
        }
    }


}
