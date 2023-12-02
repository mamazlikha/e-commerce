package anas.ecommerce.userservice.contracts;

import org.bson.types.ObjectId;

public interface IDeleteUserService {

    /**
     * Deletes a user
     * @param userId user's id
     * */
    void deleteUser(ObjectId userId);
}
