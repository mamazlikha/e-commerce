package anas.commerce.cartservice.dtos;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;


@Getter
@Setter
public class ItemDTO {

    @Nullable
    private ObjectId id;

    private double price;

    @NonNull
    private String description;


    @NonNull
    private String name;

    private int quantity;
}
