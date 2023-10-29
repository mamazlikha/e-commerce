package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.services.RemoveItemFromCartService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class RemoveItemFromCartController {

    private final Logger logger = Logger.getLogger(RemoveItemFromCartController.class.getName());

    @Autowired
    private RemoveItemFromCartService removeItemFromCartService;


    @DeleteMapping("carts/deleteitem/{cartid}/{itemid}")
    public ResponseEntity.HeadersBuilder<? extends ResponseEntity.HeadersBuilder<?>> removeItemFromCart(@PathVariable("cartid") String cartId, @PathVariable("itemid") String itemId){
        if (removeItemFromCartService.removeItem(new ObjectId(cartId), new ObjectId(itemId))){
            return ResponseEntity.noContent();
        }
        else {
            return ResponseEntity.notFound();
        }
    }
}
