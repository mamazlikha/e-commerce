package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IGetAllUsersService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class GetAllUsersService implements IGetAllUsersService {


    private final Logger logger = Logger.getLogger(GetAllUsersService.class.getName());

    @Autowired
    private IUserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> result = new ArrayList<>();
        repository.findAll().forEach(x -> result.add(mapper.map(x, UserDto.class)));
        return result;
    }
}
