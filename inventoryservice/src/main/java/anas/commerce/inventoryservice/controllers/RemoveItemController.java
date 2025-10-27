package anas.commerce.inventoryservice.controllers;

import anas.commerce.inventoryservice.contracts.IRemoveItemService;
import anas.commerce.inventoryservice.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/items")
public class RemoveItemController {

    private final IRemoveItemService removeItemService;


    @DeleteMapping(value = "/delete/{product-id}/{item-id}", produces="application/json")
    private ResponseEntity<Integer> removeItem(@PathVariable("product-id") String productId, @PathVariable ("item-id") String itemId){
        try {
            return new ResponseEntity<>(removeItemService.decreaseProductQuantity(new ObjectId(productId), new ObjectId(itemId)), HttpStatus.OK);
        }
        catch (ItemNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (RuntimeException ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally {
            log.info("Item of id : " + itemId + " of product id : " + productId + " was removed from the database");
        }
    }
}
