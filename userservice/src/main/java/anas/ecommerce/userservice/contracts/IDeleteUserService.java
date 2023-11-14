package anas.ecommerce.userservice.contracts;

import org.bson.types.ObjectId;

public interface IDeleteUserService {

    /**
     *
     * */
    void deleteUser(ObjectId userId);
}
