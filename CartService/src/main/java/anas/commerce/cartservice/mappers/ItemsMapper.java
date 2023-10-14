package anas.commerce.cartservice.mappers;


import anas.commerce.cartservice.dtos.ItemDTO;
import anas.commerce.cartservice.entities.ItemEntity;

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
