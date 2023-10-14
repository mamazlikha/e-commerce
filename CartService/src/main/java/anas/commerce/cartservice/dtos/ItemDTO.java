package anas.commerce.cartservice.dtos;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class ItemDTO {

    @Nullable
    private BigInteger id;

    private double price;

    @NonNull
    private String description;


    @NonNull
    private String name;

    private int quantity;
}
