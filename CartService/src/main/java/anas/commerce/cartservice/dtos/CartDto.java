package anas.commerce.cartservice.dtos;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.Set;

@Getter
@Setter
public class CartDto {

    @NonNull
    private ObjectId id;

    @NonNull
    private Set<ItemDTO> itemsDto;

    @NonNull
    private double totalPrice;
}
