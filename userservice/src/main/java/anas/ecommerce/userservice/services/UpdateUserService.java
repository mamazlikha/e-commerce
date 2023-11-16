package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IUpdateUserService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.UserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import anas.ecommerce.userservice.mappers.UserMapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UpdateUserService implements IUpdateUserService {

    private final Logger logger = Logger.getLogger(UpdateUserService.class.getName());

    @Autowired
    private IUserRepository repository;


    @Override
    public UserDto updateUserById(UserDto userDto, ObjectId id) throws UserNotFoundException {

        Optional<UserEntity> userEntityOptional = repository.findById(id);

        if(userEntityOptional.isPresent()){
            UserDto updatedUserDto = UserMapper.transformerToDto(userEntityOptional.get());
            updatedUserDto.setId(id.toHexString());
            return UserMapper.transformerToDto(repository.save(UserMapper.transformerToEntity(updatedUserDto)));
        }
        else {
            throw new UserNotFoundException(id);
        }

    }
}
