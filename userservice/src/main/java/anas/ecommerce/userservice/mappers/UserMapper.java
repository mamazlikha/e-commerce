package anas.ecommerce.userservice.mappers;

import anas.ecommerce.userservice.dtos.UserDto;
import anas.ecommerce.userservice.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserEntity transformerToEntity(UserDto dto){
        UserEntity result = new UserEntity(dto.getFirstname(),
                dto.getLastname(),
                dto.getBirthdate(),
                dto.getEmail(),
                dto.getPhoneNumber(),
                CartMapper.transformerToEntity(dto.getUserCartDto()),
                AddressMapper.transformerToEntity(dto.getUserAddressDto()));
        if(dto.getId() != null){
            result.setId(dto.getId());
        }
        return result;
    }

    public static UserDto transformerToDto(UserEntity entity){
        UserDto result = new UserDto(entity.getFirstname(),
                entity.getLastname(),
                entity.getBirthdate(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                AddressMapper.transformerToDto(entity.getAddress()));
        result.setUserCartDto(CartMapper.transformerToDto(entity.getUserCart()));
        if(entity.getId() != null){
            result.setId(entity.getId());
        }
        return result;
    }

    public static List<UserDto> transformerToDto(List<UserEntity> entities){
        List<UserDto> result = new ArrayList<>();

        entities.stream().map(x -> result.add(transformerToDto(x)));

        return result;
    }

}
