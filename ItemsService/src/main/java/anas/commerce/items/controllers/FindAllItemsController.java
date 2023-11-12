package anas.commerce.items.controllers;

import anas.commerce.items.contracts.IFindAllItemsService;
import anas.commerce.items.dtos.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class FindAllItemsController {


    private final Logger logger = Logger.getLogger(FindAllItemsController.class.getName());

    @Autowired
    public IFindAllItemsService findAllItemsService;

    @GetMapping("/items")
    public List<ItemDTO> getAllItems(){
        return findAllItemsService.findAll();
    }

}
