package anas.commerce.items.controllers;

import anas.commerce.items.contracts.itemsService.IAddItemService;
import anas.commerce.items.contracts.itemsService.IGetItemByIdService;
import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class GetItemByIdController {


    @Autowired
    public IGetItemByIdService getItemByIdService;



    @GetMapping("items/{id}")
    public ItemDTO getItemById(@PathVariable("id") String strId){
        BigInteger id = new BigInteger(strId);
        try {
            return getItemByIdService.getItemById(id);
        } catch (ItemNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
