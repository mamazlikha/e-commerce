package anas.commerce.cartservice.contracts;

import anas.commerce.cartservice.dtos.CartDto;
import org.bson.types.ObjectId;


public interface IAddItemToCartService {

    /**
     * Add an item to the user cart by it's id
     * @param cartId id of the user's cart
     * @param itemId item's id to add to that cart
     * @return CartDto
     * */
    CartDto addItem(ObjectId cartId, String itemId) throws Exception;

}
