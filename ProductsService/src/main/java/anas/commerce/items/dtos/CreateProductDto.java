package anas.commerce.items.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto extends ProductDTO{

    public CreateProductDto(String supplierProductNumber, double price, String name, String description){
        super(supplierProductNumber, price, name, description);
    }
}
