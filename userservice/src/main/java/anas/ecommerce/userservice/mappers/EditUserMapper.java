package anas.ecommerce.userservice.mappers;

import anas.ecommerce.userservice.dtos.userdto.EditUserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import org.bson.types.ObjectId;

public class EditUserMapper extends UserMapper {

    public static EditUserDto transformerToDto(UserEntity entity){
        return new EditUserDto(entity.getId().toHexString(),
                entity.getFirstname(),
                entity.getLastname(),
                entity.getBirthdate(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                AddressMapper.transformerToDto(entity.getAddress()));
    }

    public static UserEntity transformerToEntity(EditUserDto dto){
        UserEntity result = new UserEntity(dto.getFirstname(), dto.getLastname(), dto.getBirthdate(), dto.getEmail(), dto.getPhoneNumber(), AddressMapper.transformerToEntity(dto.getUserAddressDto()));
        result.setId(new ObjectId(dto.getId()));
        return result;
    }

}
