package anas.commerce.cartservice.dtos;

import lombok.*;
import org.bson.types.ObjectId;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class CartDto {

    @NonNull
    private String id;

    @NonNull
    private Set<ItemDTO> itemsDto;

    @NonNull
    private double totalPrice;
}
