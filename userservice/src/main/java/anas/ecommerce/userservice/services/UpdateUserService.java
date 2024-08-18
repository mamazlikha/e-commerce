package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IUpdateUserService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.userdto.EditUserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UpdateUserService implements IUpdateUserService {

    private final Logger logger = Logger.getLogger(UpdateUserService.class.getName());

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IUserRepository repository;


    @Override
    public EditUserDto updateUserById(EditUserDto editUserDto, ObjectId id) throws UserNotFoundException {

        Optional<UserEntity> userEntityOptional = repository.findById(id);

        if(userEntityOptional.isPresent()){
            EditUserDto updatedUserDto = mapper.map(userEntityOptional.get(), EditUserDto.class);
            updatedUserDto.setId(id.toHexString());
            updatedUserDto.setBirthdate(editUserDto.getBirthdate());
            updatedUserDto.setUserAddressDto(editUserDto.getUserAddressDto());
            updatedUserDto.setLastname(editUserDto.getLastname());
            updatedUserDto.setFirstname(editUserDto.getFirstname());
            updatedUserDto.setPhoneNumber(editUserDto.getPhoneNumber());
            updatedUserDto.setEmail(editUserDto.getEmail());
            return mapper.map(repository.save(mapper.map(updatedUserDto, UserEntity.class)), EditUserDto.class);
        }
        else {
            throw new UserNotFoundException(id);
        }

    }
}
