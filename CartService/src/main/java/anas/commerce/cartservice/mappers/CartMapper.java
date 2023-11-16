package anas.commerce.cartservice.mappers;

import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.entities.CartEntity;
import org.bson.types.ObjectId;

public class CartMapper {
    public static CartEntity transformerToEntity(CartDto dto){
        CartEntity result = new CartEntity();

        result.setId(new ObjectId(dto.getId()));
        result.setItems(ItemMapper.transformerToEntity(dto.getItemsDto()));
        result.setTotalPrice(dto.getTotalPrice());

        return result;
    }

    public static CartDto transformerToDto(CartEntity entity){
        CartDto result = new CartDto();

        result.setId(entity.getId().toHexString());
        result.setItemsDto(ItemMapper.transformerToDto(entity.getItems()));
        result.setTotalPrice(entity.getTotalPrice());

        return result;
    }
}
