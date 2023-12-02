package anas.commerce.items.controllers;

import anas.commerce.items.contracts.IGetProductByIdService;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.exceptions.ProductNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class GetProductByIdController {

    private final Logger logger = Logger.getLogger(GetProductByIdController.class.getName());

    @Autowired
    public IGetProductByIdService getItemByIdService;

    @GetMapping("products/{id}")
    public ProductDTO getItemById(@PathVariable("id") String strId){
        ObjectId id = new ObjectId(strId);
        try {
            return getItemByIdService.getItemById(id);
        } catch (ProductNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
