package anas.commerce.cartservice.contracts;

import anas.commerce.cartservice.dtos.CartDto;
import org.bson.types.ObjectId;


public interface IAddItemToCartService {

    /**
     * Add an item to the user cart by it's id
     * @param cartId id of the user's cart
     * @param productEntityId product's id
     * @return CartDto
     * */
    CartDto addItem(ObjectId cartId, String productEntityId) throws RuntimeException;

}
