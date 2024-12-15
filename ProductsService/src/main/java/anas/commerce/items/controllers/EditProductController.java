package anas.commerce.items.controllers;

import anas.commerce.items.contracts.IEditProductService;
import anas.commerce.items.dtos.EditProductDto;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.exceptions.ProductNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EditProductController {

    private final IEditProductService editProductService;

    @PutMapping("products/edit")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody @Valid EditProductDto newProductDtp) {
        try {
            return new ResponseEntity<>(editProductService.editProduct(newProductDtp), HttpStatus.OK);
        } catch (ProductNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            log.info("editProduct ended !");
        }
    }

}
