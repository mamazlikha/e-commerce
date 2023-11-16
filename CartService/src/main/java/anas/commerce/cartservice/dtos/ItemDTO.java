package anas.commerce.cartservice.dtos;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    @Nullable
    private String id;

    private double price;

    @NonNull
    private String description;


    @NonNull
    private String name;

    private int quantity;
}
