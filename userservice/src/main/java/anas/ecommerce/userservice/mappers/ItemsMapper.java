package anas.ecommerce.userservice.mappers;

import anas.ecommerce.userservice.dtos.ItemDto;
import anas.ecommerce.userservice.entities.ItemEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ItemsMapper {

    public static ItemEntity transformerToEntity(ItemDto dto){
        ItemEntity result = new ItemEntity();

        result.setSupplierNumber(dto.getSupplierNumber());
        result.setProductEntityId(new ObjectId(dto.getProductEntityId()));
        result.setId(new ObjectId(dto.getId()));

        return result;
    }

    public static Set<ItemEntity> transformerToEntity(Set<ItemDto> dtos){
        return dtos.stream().map(ItemsMapper::transformerToEntity).collect(Collectors.toSet());
    }


    public static ItemDto transformerToDto(ItemEntity entity){
        ItemDto result = new ItemDto();

        result.setId(entity.getId().toHexString());
        result.setProductEntityId(entity.getProductEntityId().toHexString());
        result.setSupplierNumber(entity.getSupplierNumber());

        return result;
    }

    public static Set<ItemDto> transformerToDto(Set<ItemEntity> entities){
        return entities.stream().map(ItemsMapper::transformerToDto).collect(Collectors.toSet());
    }


}
