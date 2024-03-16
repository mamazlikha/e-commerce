package anas.commerce.items.controllers;

import anas.commerce.items.contracts.IAddNewProductService;
import anas.commerce.items.dtos.CreateProductDto;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.exceptions.ProductAlreadyExistException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class AddProductsController {

    private final Logger logger = Logger.getLogger(AddProductsController.class.getName());

    @Autowired
    public IAddNewProductService addItemService;


    @PostMapping("products/add")
    public ResponseEntity<ProductDTO> addNewProduct(@RequestBody @Valid CreateProductDto createProductDTO) {
        try {
            return new ResponseEntity<>(this.addItemService.addNewProduct(createProductDTO), HttpStatus.CREATED);

        }catch (ProductAlreadyExistException ex){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
