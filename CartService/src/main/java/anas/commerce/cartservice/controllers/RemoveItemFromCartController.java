package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.contracts.IRemoveItemFromCartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/carts")
public class RemoveItemFromCartController {

    private final IRemoveItemFromCartService removeItemFromCartService;

    @DeleteMapping("/deleteitem/{cartid}/{itemid}")
    public ResponseEntity.HeadersBuilder<?> removeItemFromCart(@PathVariable("cartid") String cartId, @PathVariable("itemid") String itemId){
        if (removeItemFromCartService.removeItem(new ObjectId(cartId), new ObjectId(itemId))){
            return ResponseEntity.noContent();
        }
        else {
            return ResponseEntity.notFound();
        }
    }
}
