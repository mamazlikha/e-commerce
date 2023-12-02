package anas.commerce.inventoryservice.mappers;

import anas.commerce.inventoryservice.dtos.ItemDto;
import anas.commerce.inventoryservice.entities.ItemEntity;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemsMapper {

    public static ItemEntity transformerToEntity(ItemDto dto){
        ItemEntity result = new ItemEntity();

        result.setSupplierNumber(dto.getSupplierNumber());
        result.setProductEntityId(new ObjectId(dto.getProductEntityId()));
        result.setId(new ObjectId(dto.getId()));

        return result;
    }


    public static ItemDto transformerToDto(ItemEntity entity){
        ItemDto result = new ItemDto();

        result.setId(entity.getId().toHexString());
        result.setProductEntityId(entity.getProductEntityId().toHexString());
        result.setSupplierNumber(entity.getSupplierNumber());

        return result;
    }

    public static List<ItemDto> transformerToDto(List<ItemEntity> entities){
        return entities.stream().map(ItemsMapper::transformerToDto).collect(Collectors.toList());
    }


}
