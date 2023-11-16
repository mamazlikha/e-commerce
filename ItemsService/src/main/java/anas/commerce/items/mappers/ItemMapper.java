package anas.commerce.items.mappers;

import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.entities.ItemEntity;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {

    public static ItemEntity transformerToEntity(ItemDTO dto){
        ItemEntity result = new ItemEntity();

        result.setDescription(dto.getDescription());
        result.setName(dto.getName());
        result.setId(new ObjectId(dto.getId()));
        result.setPrice(dto.getPrice());

        return result;
    }

    public static ItemDTO transformerToDto(ItemEntity entity){
        ItemDTO result = new ItemDTO();

        result.setDescription(entity.getDescription());
        result.setName(entity.getName());
        result.setId(entity.getId().toHexString());
        result.setPrice(entity.getPrice());

        return result;
    }
    public static List<ItemDTO> transformerToDto(List<ItemEntity> entities){
        return entities.stream().map(ItemMapper::transformerToDto).collect(Collectors.toList());
    }


}
