package anas.commerce.items.dtos;

import com.mongodb.lang.NonNull;
import lombok.*;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NonNull
    protected String supplierProductNumber;

    @NonNull
    protected double price;

    @NonNull
    protected String name;

    @NonNull
    protected String description;
}
