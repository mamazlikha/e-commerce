package anas.ecommerce.userservice.mappers;

import anas.ecommerce.userservice.dtos.userdto.CreateUserDto;
import anas.ecommerce.userservice.entities.UserEntity;

public class CreateUserMapper extends UserMapper{

    public static CreateUserDto transformerToDto(UserEntity entity){
        CreateUserDto result = new CreateUserDto(entity.getFirstname(),
                entity.getLastname(),
                entity.getBirthdate(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                AddressMapper.transformerToDto(entity.getAddress()));
        result.setId(entity.getId().toHexString());
        result.setUserCartDto(CartMapper.transformerToDto(entity.getUserCart()));
        return result;
    }

    public static UserEntity transformerToEntity(CreateUserDto dto){
        UserEntity result = new UserEntity(dto.getFirstname(), dto.getLastname(), dto.getBirthdate(), dto.getEmail(), dto.getPhoneNumber(), AddressMapper.transformerToEntity(dto.getUserAddressDto()));
        result.setUserCart(CartMapper.transformerToEntity(dto.getUserCartDto()));
        return result;
    }

}
