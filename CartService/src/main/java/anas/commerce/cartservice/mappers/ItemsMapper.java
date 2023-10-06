package anas.commerce.cartservice.mappers;

import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.entities.ItemEntity;

public class ItemsMapper {

    public static ItemEntity transformer(ItemDTO dto){
        ItemEntity result = new ItemEntity();

        result.setDescription(dto.getDescription());
        result.setId(dto.getId());
        result.setPrice(dto.getPrice());
        result.setQuantity(dto.getQuantity());

        return result;
    }
}
