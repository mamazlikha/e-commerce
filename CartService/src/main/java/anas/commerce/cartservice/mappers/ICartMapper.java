package anas.commerce.cartservice.mappers;

import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.entities.CartEntity;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ICartMapper {

    @Mapping(source = "id", target = "id", qualifiedByName = "idToString")
    CartDto cartEntityToCartDto(CartEntity cartEntity);
    @Mapping(source = "id", target = "id", qualifiedByName = "stringToId")
    CartEntity cartDtoToCartEntity(CartDto dto);

    @Named("idToString")
    default String idToString(ObjectId id){
        return id.toString();
    }

    @Named("stringToId")
    default ObjectId stringToId(String id){
        return new ObjectId(id);
    }

}
