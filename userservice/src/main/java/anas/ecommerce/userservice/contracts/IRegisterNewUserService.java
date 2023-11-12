package anas.ecommerce.userservice.contracts;

import anas.ecommerce.userservice.dtos.UserDto;

public interface IRegisterNewUserService {


    /**
     *
     * */
    UserDto registerUser(UserDto userDto);
}
