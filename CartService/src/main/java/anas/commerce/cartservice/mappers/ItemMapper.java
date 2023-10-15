package anas.commerce.cartservice.mappers;


import anas.commerce.cartservice.dtos.ItemDTO;
import anas.commerce.cartservice.entities.ItemEntity;

import java.util.HashSet;
import java.util.Set;

public class ItemMapper {

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

    public static Set<ItemEntity> transformerToEntity(Set<ItemDTO> dtos){
        Set<ItemEntity> entities = new HashSet<>();
        for (ItemDTO dto: dtos
             ) {
            entities.add(transformerToEntity(dto));

        }
        return entities;
    }

    public static Set<ItemDTO> transformerToDto(Set<ItemEntity> entities){
        Set<ItemDTO> dtos = new HashSet<>();
        for (ItemEntity e: entities
        ) {
            dtos.add(transformerToDto(e));

        }
        return dtos;
    }


}
