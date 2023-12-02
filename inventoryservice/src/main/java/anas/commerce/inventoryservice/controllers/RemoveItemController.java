package anas.commerce.inventoryservice.controllers;

import anas.commerce.inventoryservice.contracts.IRemoveItemService;
import anas.commerce.inventoryservice.exceptions.ItemNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.logging.Logger;

@RestController
public class RemoveItemController {

    private final Logger logger = Logger.getLogger(RemoveItemController.class.getName());

    @Autowired
    private IRemoveItemService removeItemService;


    @DeleteMapping("items/delete/{product-id}/{item-id}")
    private ResponseEntity<Integer> removeItem(@PathVariable("product-id") String productId, @PathVariable ("item-id") String itemId){
        try {
            return new ResponseEntity<>(removeItemService.decreaseProductQuantity(new ObjectId(productId), new ObjectId(itemId)), HttpStatus.NO_CONTENT);
        }
        catch (ItemNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (RuntimeException ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally {

        }
    }
}
