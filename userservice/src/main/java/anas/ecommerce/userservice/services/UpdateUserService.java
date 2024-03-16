package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IUpdateUserService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.userdto.EditUserDto;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import anas.ecommerce.userservice.mappers.EditUserMapper;
import anas.ecommerce.userservice.mappers.UserMapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UpdateUserService implements IUpdateUserService {

    private final Logger logger = Logger.getLogger(UpdateUserService.class.getName());

    @Autowired
    private IUserRepository repository;


    @Override
    public EditUserDto updateUserById(EditUserDto editUserDto, ObjectId id) throws UserNotFoundException {

        Optional<UserEntity> userEntityOptional = repository.findById(id);

        if(userEntityOptional.isPresent()){
            EditUserDto updatedUserDto = EditUserMapper.transformerToDto(userEntityOptional.get());
            updatedUserDto.setId(id.toHexString());
            updatedUserDto.setBirthdate(editUserDto.getBirthdate());
            updatedUserDto.setUserAddressDto(editUserDto.getUserAddressDto());
            updatedUserDto.setLastname(editUserDto.getLastname());
            updatedUserDto.setFirstname(editUserDto.getFirstname());
            updatedUserDto.setPhoneNumber(editUserDto.getPhoneNumber());
            updatedUserDto.setEmail(editUserDto.getEmail());
            return EditUserMapper.transformerToDto(repository.save(EditUserMapper.transformerToEntity(updatedUserDto)));
        }
        else {
            throw new UserNotFoundException(id);
        }

    }
}
