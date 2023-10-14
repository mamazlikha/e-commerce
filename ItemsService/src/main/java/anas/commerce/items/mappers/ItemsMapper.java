package anas.commerce.items.mappers;

import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.entities.ItemEntity;

public class ItemsMapper {

    public static ItemEntity transformerToEntity(ItemDTO dto){
        ItemEntity result = new ItemEntity();

        result.setDescription(dto.getDescription());
        result.setId(dto.getId());
        result.setPrice(dto.getPrice());

        return result;
    }

    public static ItemDTO transformerToDto(ItemEntity entity){
        ItemDTO result = new ItemDTO();

        result.setDescription(entity.getDescription());
        result.setId(entity.getId());
        result.setPrice(entity.getPrice());

        return result;
    }
}
