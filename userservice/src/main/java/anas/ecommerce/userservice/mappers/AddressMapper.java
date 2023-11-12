package anas.ecommerce.userservice.mappers;

import anas.ecommerce.userservice.dtos.AddressDto;
import anas.ecommerce.userservice.entities.AddressEntity;

public class AddressMapper {

    public static AddressEntity transformerToEntity(AddressDto dto){
        return new AddressEntity(dto.getStreetNumber(),
                dto.getStreetName(),
                dto.getZipCode(),
                dto.getCity(),
                dto.getCountry());
    }

    public static AddressDto transformerToDto(AddressEntity entity){
        return new AddressDto(entity.getStreetNumber(),
                entity.getStreetName(),
                entity.getZipCode(),
                entity.getCity(),
                entity.getCountry());
    }

}
