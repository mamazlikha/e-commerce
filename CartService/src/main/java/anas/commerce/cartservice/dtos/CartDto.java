package anas.commerce.cartservice.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
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
