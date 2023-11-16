package anas.commerce.cartservice.mappers;


import anas.commerce.cartservice.dtos.ItemDTO;
import anas.commerce.cartservice.entities.ItemEntity;
import org.bson.types.ObjectId;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ItemMapper {

    public static ItemEntity transformerToEntity(ItemDTO dto){
        ItemEntity result = new ItemEntity();

        result.setDescription(dto.getDescription());
        result.setId(new ObjectId(dto.getId()));
        result.setPrice(dto.getPrice());

        return result;
    }

    public static ItemDTO transformerToDto(ItemEntity entity){
        ItemDTO result = new ItemDTO();

        result.setDescription(entity.getDescription());
        result.setId(entity.getId().toHexString());
        result.setPrice(entity.getPrice());

        return result;
    }

    public static Set<ItemEntity> transformerToEntity(Set<ItemDTO> dtos){
        return dtos.stream().map(ItemMapper::transformerToEntity).collect(Collectors.toSet());
    }

    public static Set<ItemDTO> transformerToDto(Set<ItemEntity> entities){
        return entities.stream().map(ItemMapper::transformerToDto).collect(Collectors.toSet());
    }


}
