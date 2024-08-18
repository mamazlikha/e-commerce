package anas.commerce.cartservice.mappers;

import anas.commerce.cartservice.dtos.ItemDTO;
import anas.commerce.cartservice.entities.ItemEntity;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface IItemMapper {

    @Mapping(source = "id", target = "id", qualifiedByName = "idToString")
    @Mapping(source = "productEntityId", target = "productEntityId", qualifiedByName = "productEntityIdToString")
    ItemDTO itemEntityToItemDto(ItemEntity itemEntity);
    @Mapping(source = "id", target = "id", qualifiedByName = "stringToId")
    @Mapping(source = "productEntityId", target = "productEntityId", qualifiedByName = "productEntityIdToObjectId")
    ItemEntity itemDtoToItemEntity(ItemDTO dto);

    @Named("idToString")
    default String idToString(ObjectId id){
        return id.toString();
    }
    @Named("productEntityIdToString")
    default String productEntityIdToString(ObjectId id){
        return id.toString();
    }

    @Named("stringToId")
    default ObjectId stringToId(String id){
        return new ObjectId(id);
    }
    @Named("productEntityIdToObjectId")
    default ObjectId productEntityIdToObjectId(String id){
        return new ObjectId(id);
    }
}
