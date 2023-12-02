package anas.ecommerce.userservice.contracts;

import anas.ecommerce.userservice.dtos.UserDto;

public interface IRegisterNewUserService {


    /**
     * Adds a new user
     * @param userDto user's required information
     * */
    UserDto registerUser(UserDto userDto);
}
