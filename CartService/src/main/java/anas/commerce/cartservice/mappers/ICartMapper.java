package anas.commerce.cartservice.mappers;

import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.dtos.ItemDTO;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.entities.ItemEntity;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ICartMapper {

    @Mapping(source = "id", target = "id", qualifiedByName = "idToString")
    @Mapping(source = "items", target = "itemsDto", qualifiedByName = "itemDtosToitemEntities")
    CartDto cartEntityToCartDto(CartEntity cartEntity);

    @Mapping(source = "id", target = "id", qualifiedByName = "stringToId")
    @Mapping(source = "itemsDto", target = "items", qualifiedByName = "itemEntitesToitemDtos")
    CartEntity cartDtoToCartEntity(CartDto dto);


    @Named("idToString")
    default String idToString(ObjectId id){
        return id != null ? id.toString() : null;
    }

    @Named("stringToId")
    default ObjectId stringToId(String id){
        return id != null ? new ObjectId(id) : null;
    }


    @Named("itemEntitesToitemDtos")
    default Set<ItemEntity> itemEntitesToitemDtos(Set<ItemDTO> itemsDto){
        Set<ItemEntity> result = new HashSet<>();

        for(ItemDTO itemDTO: itemsDto){
            if(itemDTO != null){
                result.add(new ItemEntity(new ObjectId(itemDTO.getId()), new ObjectId(itemDTO.getProductEntityId())));
            }
        }
        return result;
    }

    @Named("itemDtosToitemEntities")
    default Set<ItemDTO> itemDtosToitemEntities(Set<ItemEntity> items){
        Set<ItemDTO> result = new HashSet<>();

        for(ItemEntity itemEntity: items){
            if(itemEntity != null){
                result.add(new ItemDTO(itemEntity.getId().toHexString(), itemEntity.getProductEntityId().toHexString()));
            }
        }
        return result;
    }

}
