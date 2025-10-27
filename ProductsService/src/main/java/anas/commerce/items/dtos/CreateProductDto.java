package anas.commerce.items.dtos;

import lombok.*;

@Getter
@Setter
public class CreateProductDto extends ProductDTO{

    public CreateProductDto(String supplierProductNumber, double price, String name, String description){
        super(supplierProductNumber, price, name, description);
    }
}
