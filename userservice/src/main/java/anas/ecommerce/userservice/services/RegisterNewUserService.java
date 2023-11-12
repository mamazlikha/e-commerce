package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IRegisterNewUserService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.UserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import anas.ecommerce.userservice.exceptions.UserAlreadyExistException;
import anas.ecommerce.userservice.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RegisterNewUserService implements IRegisterNewUserService {

    private final Logger logger = Logger.getLogger(RegisterNewUserService.class.getName());

    @Autowired
    private IUserRepository repository;

    public UserDto registerUser(UserDto userDto) {
        Optional<UserEntity> alreadyExist = repository.findByEmailOrPhoneNumber(userDto.getEmail(), userDto.getPhoneNumber());
        if(alreadyExist.isEmpty()){
            return UserMapper.transformerToDto(repository.save(UserMapper.transformerToEntity(userDto)));
        }
        throw new UserAlreadyExistException(userDto.getEmail(), userDto.getPhoneNumber());
    }
}
