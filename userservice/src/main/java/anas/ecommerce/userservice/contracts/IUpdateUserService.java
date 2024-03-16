package anas.ecommerce.userservice.contracts;

import anas.ecommerce.userservice.dtos.userdto.EditUserDto;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import anas.ecommerce.userservice.mappers.EditUserMapper;
import org.bson.types.ObjectId;


public interface IUpdateUserService {

    /**
     * Updates a user by id with new information
     * @param editUserDto New information to add
     * @param userId user's id
     * @return UserDto
     * */
    EditUserDto updateUserById(EditUserDto editUserDto, ObjectId userId) throws UserNotFoundException;
}
