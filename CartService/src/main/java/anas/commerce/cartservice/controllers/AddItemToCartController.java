package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.contracts.IAddItemToCartService;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.exceptions.ProductServiceIsInvalidException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AddItemToCartController {


    private final IAddItemToCartService addItemToCartService;

    @PostMapping("carts/additem/{cartId}/{itemId}")
    public ResponseEntity<CartDto> addItem(@PathVariable("cartId") String cartId, @PathVariable String itemId){
        ObjectId cartIdParameter = new ObjectId(cartId);
        try {
            return new ResponseEntity<>(addItemToCartService.addItem(cartIdParameter, itemId), HttpStatus.CREATED);
        }
        catch (ProductServiceIsInvalidException e) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        catch (RuntimeException ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally {
            log.info("addItem method is finished !");
        }
    }


}
