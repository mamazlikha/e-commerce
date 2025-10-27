package anas.commerce.items.controllers;

import anas.commerce.items.contracts.IGetProductByIdService;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.exceptions.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/products")
public class GetProductByIdController {

    private final IGetProductByIdService getItemByIdService;

    @GetMapping(value = "/{id}", produces="application/json")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") String strId){
        ObjectId id = new ObjectId(strId);
        try {
            return new ResponseEntity<>(getItemByIdService.getProductById(id), HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
