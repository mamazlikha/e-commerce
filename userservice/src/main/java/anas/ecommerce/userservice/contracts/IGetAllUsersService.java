package anas.ecommerce.userservice.contracts;

import anas.ecommerce.userservice.dtos.UserDto;

import java.util.List;

public interface IGetAllUsersService {


    /**
     *
     * */
    List<UserDto> getAllUsers();

}
