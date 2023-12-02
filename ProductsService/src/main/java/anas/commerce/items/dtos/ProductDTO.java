package anas.commerce.items.dtos;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class ProductDTO {


    @Nullable
    private String id;


    @NonNull
    private String supplierNumber;

    @NonNull
    private double price;

    @NonNull
    private String name;

    @NonNull
    private String description;



}
