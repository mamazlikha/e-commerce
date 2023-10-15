package anas.commerce.items.controllers;

import anas.commerce.items.contracts.IItemsService;
import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.entities.ItemEntity;
import anas.commerce.items.exception.ItemNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class ItemsController {

    @Autowired
    public IItemsService itemsService;

    @GetMapping("/items")
    public List<ItemDTO> getAllItems(){
        return itemsService.findAll();
    }

    @PostMapping("items/add")
    public ResponseEntity<ItemDTO> addItem(@RequestBody @Valid ItemDTO itemDTO){
        try {
            return ResponseEntity.ok(this.itemsService.addItem(itemDTO));
        } catch (Exception e) {
            System.out.printf(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("items/{id}")
    public ItemDTO getItemById(@PathVariable("id") String strId){
        BigInteger id = new BigInteger(strId);
        try {
            return itemsService.getItemById(id);
        } catch (ItemNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
