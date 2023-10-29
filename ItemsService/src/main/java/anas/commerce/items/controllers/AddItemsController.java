package anas.commerce.items.controllers;

import anas.commerce.items.contracts.itemsService.IAddItemService;
import anas.commerce.items.dtos.ItemDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class AddItemsController {

    private final Logger logger = Logger.getLogger(AddItemsController.class.getName());

    @Autowired
    public IAddItemService addItemService;


    @PostMapping("items/add")
    public ResponseEntity<ItemDTO> addItem(@RequestBody @Valid ItemDTO itemDTO){
        try {
            return ResponseEntity.ok(this.addItemService.addItem(itemDTO));
        } catch (Exception e) {
            System.out.printf(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
