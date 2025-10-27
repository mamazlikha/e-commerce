package anas.commerce.items.controllers;

import anas.commerce.items.contracts.IFindAllProductsService;
import anas.commerce.items.dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/products")
public class FindAllProductsController {


    private final IFindAllProductsService findAllItemsService;

    @GetMapping(value = "", produces="application/json")
    public List<ProductDTO> getAllItems(){
        return findAllItemsService.findAll();
    }

}
