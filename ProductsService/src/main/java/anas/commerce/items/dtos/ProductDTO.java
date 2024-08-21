package anas.commerce.items.dtos;

import com.mongodb.lang.NonNull;
import lombok.*;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ProductDTO {


    @NonNull
    private String supplierProductNumber;

    @NonNull
    private double price;

    @NonNull
    private String name;

    @NonNull
    private String description;
}
