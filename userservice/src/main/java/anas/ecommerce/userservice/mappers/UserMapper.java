package anas.ecommerce.userservice.mappers;

import anas.ecommerce.userservice.dtos.UserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

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
            result.setId(new ObjectId(dto.getId()));
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
            result.setId(entity.getId().toHexString());
        }
        return result;
    }

    public static List<UserDto> transformerToDto(List<UserEntity> entities){
        return entities.stream()
                .map(UserMapper::transformerToDto)
                .collect(Collectors.toList());

    }

}
