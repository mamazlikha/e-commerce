package anas.commerce.items.controllers;

import anas.commerce.items.contracts.itemsService.IAddItemService;
import anas.commerce.items.contracts.itemsService.IFindAllItemsService;
import anas.commerce.items.dtos.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindAllItemsController {


    @Autowired
    public IFindAllItemsService findAllItemsService;

    @GetMapping("/items")
    public List<ItemDTO> getAllItems(){
        return findAllItemsService.findAll();
    }

}
