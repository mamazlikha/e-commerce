package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.contracts.IGetCartByUSerIdService;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.exceptions.CartNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/carts")
public class GetCartByUSerIdController {

    private final IGetCartByUSerIdService getCartByUserIdService;

    @GetMapping(value = "/getcartby/{id}", produces="application/json")
    public ResponseEntity<CartDto> getCartById(@PathVariable("id") String userId){
        try {
            log.info("Getting cart for userid : " + userId);
            return new ResponseEntity<>(getCartByUserIdService.getCartByUserId(new ObjectId(userId)), HttpStatus.OK);
        }
        catch (CartNotFoundException e) {
            log.error("User id is invalid");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
