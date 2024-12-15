package anas.commerce.items.controllers;

import anas.commerce.items.contracts.IAddNewProductService;
import anas.commerce.items.dtos.CreateProductDto;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.exceptions.ProductAlreadyExistException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AddProductsController {

    private final IAddNewProductService addItemService;


    @PostMapping("products/add")
    public ResponseEntity<ProductDTO> addNewProduct(@RequestBody @Valid CreateProductDto createProductDTO) {
        try {
            return new ResponseEntity<>(this.addItemService.addNewProduct(createProductDTO), HttpStatus.CREATED);
        } catch (ProductAlreadyExistException ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
