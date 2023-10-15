package anas.commerce.cartservice.dtos;

import anas.commerce.cartservice.entities.ItemEntity;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Set;

@Getter
@Setter
public class CartDto {

    @NonNull
    private BigInteger id;

    @NonNull
    private Set<ItemDTO> itemsDto;

    @NonNull
    private double totalPrice;
}
