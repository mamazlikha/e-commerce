package anas.commerce.cartservice.mappers;

import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.entities.CartEntity;

public class CartMapper {
    public static CartEntity transformerToEntity(CartDto dto){
        CartEntity result = new CartEntity();

        result.setId(dto.getId());
        result.setItems(ItemMapper.transformerToEntity(dto.getItemsDto()));
        result.setTotalPrice(dto.getTotalPrice());

        return result;
    }

    public static CartDto transformerToDto(CartEntity entity){
        CartDto result = new CartDto();

        result.setId(entity.getId());
        result.setItemsDto(ItemMapper.transformerToDto(entity.getItems()));
        result.setTotalPrice(entity.getTotalPrice());

        return result;
    }
}
