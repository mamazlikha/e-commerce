package anas.ecommerce.userservice.contracts;

import anas.ecommerce.userservice.dtos.UserDto;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import org.bson.types.ObjectId;


public interface IUpdateUserService {

    /**
     *
     * */
    UserDto updateUserById(UserDto userDto, ObjectId objectId) throws UserNotFoundException;
}
