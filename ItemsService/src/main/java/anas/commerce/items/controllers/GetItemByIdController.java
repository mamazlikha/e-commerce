package anas.commerce.items.controllers;

import anas.commerce.items.contracts.IGetItemByIdService;
import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.exception.ItemNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class GetItemByIdController {

    private final Logger logger = Logger.getLogger(GetItemByIdController.class.getName());

    @Autowired
    public IGetItemByIdService getItemByIdService;

    @GetMapping("items/{id}")
    public ItemDTO getItemById(@PathVariable("id") String strId){
        ObjectId id = new ObjectId(strId);
        try {
            return getItemByIdService.getItemById(id);
        } catch (ItemNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
