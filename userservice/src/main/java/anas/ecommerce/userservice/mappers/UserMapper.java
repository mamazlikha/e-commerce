package anas.ecommerce.userservice.mappers;

import anas.ecommerce.userservice.dtos.userdto.CreateUserDto;
import anas.ecommerce.userservice.dtos.userdto.EditUserDto;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto transformerToDto(UserEntity entity){
        return new UserDto(entity.getFirstname(),
                entity.getLastname(),
                entity.getBirthdate(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                AddressMapper.transformerToDto(entity.getAddress()));
    }

    public static List<UserDto> transformerToDto(List<UserEntity> entities){
        return entities.stream()
                .map(UserMapper::transformerToDto)
                .collect(Collectors.toList());

    }

}
