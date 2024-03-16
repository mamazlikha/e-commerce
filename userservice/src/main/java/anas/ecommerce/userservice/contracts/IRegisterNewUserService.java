package anas.ecommerce.userservice.contracts;

import anas.ecommerce.userservice.dtos.userdto.CreateUserDto;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import anas.ecommerce.userservice.mappers.CreateUserMapper;

public interface IRegisterNewUserService {


    /**
     * Adds a new user
     * @param createUserDto user's required information
     * */
    CreateUserDto registerUser(CreateUserDto createUserDto);
}
