package anas.commerce.items.controllers;

import anas.commerce.items.contracts.IItemsService;
import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.entities.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemsController {


    @Autowired
    public IItemsService itemsService;

    @GetMapping("/items")
    public List<ItemEntity> getAllItems(){
        return itemsService.findAll();
    }
}
