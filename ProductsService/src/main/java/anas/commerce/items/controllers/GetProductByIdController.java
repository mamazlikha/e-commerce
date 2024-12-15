package anas.commerce.items.controllers;

import anas.commerce.items.contracts.IGetProductByIdService;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.exceptions.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
public class GetProductByIdController {

    private final IGetProductByIdService getItemByIdService;

    @GetMapping("products/{id}")
    public ProductDTO getProductById(@PathVariable("id") String strId){
        ObjectId id = new ObjectId(strId);
        try {
            return getItemByIdService.getProductById(id);
        } catch (ProductNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
