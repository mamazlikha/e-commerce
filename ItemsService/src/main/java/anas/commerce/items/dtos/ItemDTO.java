package anas.commerce.items.dtos;

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

    @NonNull
    private double price;

    @NonNull
    private String name;

    @NonNull
    private String description;

    public ItemDTO(ObjectId id, double price, String name, String description){
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public ItemDTO(){

    }

}
