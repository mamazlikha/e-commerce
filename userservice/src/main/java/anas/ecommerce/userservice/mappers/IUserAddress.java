package anas.ecommerce.userservice.mappers;

import anas.ecommerce.userservice.dtos.AddressDto;
import anas.ecommerce.userservice.entities.AddressEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserAddress {
    AddressEntity dtoToEntity(AddressDto dto);
    AddressDto entityToDto(AddressEntity entity);
}
