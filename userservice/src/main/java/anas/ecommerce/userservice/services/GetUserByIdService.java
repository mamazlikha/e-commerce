package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IGetUserByIdService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.UserDto;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import anas.ecommerce.userservice.mappers.UserMapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class GetUserByIdService implements IGetUserByIdService {


    private final Logger logger = Logger.getLogger(GetUserByIdService.class.getName());


    @Autowired
    private IUserRepository repository;


    @Override
    public UserDto getUserById(ObjectId id) throws RuntimeException {
        return UserMapper.transformerToDto(repository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }
}
