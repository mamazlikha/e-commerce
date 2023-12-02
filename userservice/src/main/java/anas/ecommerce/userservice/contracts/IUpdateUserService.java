package anas.ecommerce.userservice.contracts;

import anas.ecommerce.userservice.dtos.UserDto;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import org.bson.types.ObjectId;


public interface IUpdateUserService {

    /**
     * Updates a user by id with new information
     * @param userDto New information to add
     * @param userId user's id
     * @return UserDto
     * */
    UserDto updateUserById(UserDto userDto, ObjectId userId) throws UserNotFoundException;
}
