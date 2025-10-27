package anas.commerce.inventoryservice.controllers;

import anas.commerce.inventoryservice.contracts.IAddNewItemService;
import anas.commerce.inventoryservice.dtos.ItemDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/items")
public class AddNEwItemController {


    private final IAddNewItemService addNewItemService;

    @PostMapping(value = "/add/{product-id}", produces="application/json")
    public ResponseEntity<Void> addItem(@PathVariable("product-id") String productId){
        if(addNewItemService.increaseProductQuantity(new ObjectId(productId))){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
