package anas.ecommerce.userservice.contracts;

import anas.ecommerce.userservice.dtos.userdto.UserDto;

import java.util.List;

public interface IGetAllUsersService {


    /**
     *
     * */
    List<UserDto> getAllUsers();

}
