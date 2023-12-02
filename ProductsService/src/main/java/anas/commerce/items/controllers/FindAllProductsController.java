package anas.commerce.items.controllers;

import anas.commerce.items.contracts.IFindAllProductsService;
import anas.commerce.items.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class FindAllProductsController {


    private final Logger logger = Logger.getLogger(FindAllProductsController.class.getName());

    @Autowired
    public IFindAllProductsService findAllItemsService;

    @GetMapping("/products")
    public List<ProductDTO> getAllItems(){
        return findAllItemsService.findAll();
    }

}
