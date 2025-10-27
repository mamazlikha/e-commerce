package anas.commerce.inventoryservice.controllers;

import anas.commerce.inventoryservice.contracts.IGetItemByProductIdService;
import anas.commerce.inventoryservice.dtos.ItemDto;
import anas.commerce.inventoryservice.exceptions.EmptyItemsForProductException;
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
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/items")
public class GetItemByProductIdController {


    private final IGetItemByProductIdService service;

    @GetMapping(value = "/{product-id}", produces="application/json")
    public ResponseEntity<ItemDto> getItemByProductId(@PathVariable("product-id") String id){
        try {
            return new ResponseEntity<>(service.getItemByProductId(new ObjectId(id)), HttpStatus.OK);
        } catch (EmptyItemsForProductException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
