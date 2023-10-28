package anas.commerce.items.dtos;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

@Getter
@Setter
public class ItemDTO {


    @Nullable
    private BigInteger id;

    @NonNull
    private double price;

    @NonNull
    private String name;

    @NonNull
    private String description;

    public ItemDTO(BigInteger id, double price, String name, String description){
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public ItemDTO(){

    }

}
