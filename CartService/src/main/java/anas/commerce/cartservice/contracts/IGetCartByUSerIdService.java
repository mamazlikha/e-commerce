package anas.commerce.cartservice.contracts;

import anas.commerce.cartservice.dtos.CartDto;
import org.bson.types.ObjectId;

public interface IGetCartByUSerIdService {

    /**
     * @param userId user's id
     * @return CartDto by it's user's id
     * */
    CartDto getCartByUserId(ObjectId userId) throws RuntimeException;

}
