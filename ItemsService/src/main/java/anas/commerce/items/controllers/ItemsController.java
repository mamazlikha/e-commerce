package anas.commerce.items.controllers;

import anas.commerce.items.contracts.IItemsService;
import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.entities.ItemEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
public class ItemsController {


    @Autowired
    public IItemsService itemsService;

    @GetMapping("/items")
    public List<ItemEntity> getAllItems(){
        return itemsService.findAll();
    }

    @PostMapping("/items/add")
    public ResponseEntity<String> addItem(@RequestBody @Valid ItemDTO itemDTO){
        try{
            this.itemsService.addItem(itemDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Item was created");
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");

    }
}
