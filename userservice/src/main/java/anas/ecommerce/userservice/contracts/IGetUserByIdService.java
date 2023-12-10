package anas.ecommerce.userservice.contracts;

import anas.ecommerce.userservice.dtos.UserDto;
import org.bson.types.ObjectId;

public interface IGetUserByIdService {


    /**
     *
     * */
    UserDto getUserById(ObjectId id) throws RuntimeException;
}
