package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IGetUserByIdService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class GetUserByIdService implements IGetUserByIdService {


    private final Logger logger = Logger.getLogger(GetUserByIdService.class.getName());


    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IUserRepository repository;


    @Override
    public UserDto getUserById(ObjectId id) throws RuntimeException {
        return mapper.map(repository.findById(id).orElseThrow(() -> new UserNotFoundException(id)), UserDto.class);
    }
}
