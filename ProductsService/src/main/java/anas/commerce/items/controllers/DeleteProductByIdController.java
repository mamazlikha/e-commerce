package anas.commerce.items.controllers;

import anas.commerce.items.contracts.IDeleteProductByIdService;
import anas.commerce.items.dtos.ProductDTO;
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
public class DeleteProductByIdController {

    private final IDeleteProductByIdService deleteProductByIdService;

    @GetMapping(value = "/delete/{id}", produces="application/json")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String strId){
        if(deleteProductByIdService.deleteById(new ObjectId(strId))){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
