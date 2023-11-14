package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IGetAllUsersService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.UserDto;
import anas.ecommerce.userservice.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUsersService implements IGetAllUsersService {


    @Autowired
    private IUserRepository repository;


    @Override
    public List<UserDto> getAllUsers() {
        return UserMapper.transformerToDto(repository.findAll());
    }
}
