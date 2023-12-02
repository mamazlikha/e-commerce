package anas.commerce.inventoryservice.controllers;

import anas.commerce.inventoryservice.contracts.IEditItemsService;
import anas.commerce.inventoryservice.contracts.IRemoveItemService;
import anas.commerce.inventoryservice.dtos.ItemDto;
import anas.commerce.inventoryservice.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class EditItemController {

    private final Logger logger = Logger.getLogger(EditItemController.class.getName());

    @Autowired
    private IEditItemsService editItemsService;

    @PutMapping("items/edit")
    public ResponseEntity<ItemDto> editItem(@RequestBody @Valid ItemDto newItemDto){
        try {
            return new ResponseEntity<>(editItemsService.editItem(newItemDto), HttpStatus.OK);
        }
        catch (ItemNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally {

        }
    }
}
