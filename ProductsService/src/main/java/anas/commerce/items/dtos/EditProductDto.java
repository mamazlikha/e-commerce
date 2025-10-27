package anas.commerce.items.dtos;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class EditProductDto extends ProductDTO {

    @NonNull
    private String id;

    public EditProductDto(String id, String supplierNumber, double price, String name, String description){
        super(supplierNumber, price, name, description);
        this.id = id;
    }
}
