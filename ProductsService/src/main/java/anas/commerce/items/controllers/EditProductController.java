package anas.commerce.items.controllers;

import anas.commerce.items.contracts.IEditProductService;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.exceptions.ProductNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class EditProductController {

    private final Logger logger = Logger.getLogger(EditProductController.class.getName());

    @Autowired
    private IEditProductService editProductService;

    @PutMapping("products/edit")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody @Valid ProductDTO newProductDtp) {
        try {
            return new ResponseEntity<>(editProductService.editProduct(newProductDtp), HttpStatus.OK);
        } catch (ProductNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            logger.log(Level.ALL, "editProduct ended !");
        }
    }

}
