package anas.commerce.inventoryservice.controllers;

import anas.commerce.inventoryservice.contracts.IEditItemsService;
import anas.commerce.inventoryservice.dtos.ItemDto;
import anas.commerce.inventoryservice.exceptions.ItemNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/items")
public class EditItemController {


    private final IEditItemsService editItemsService;

    @PutMapping(value = "/edit", produces="application/json")
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
