package anas.commerce.cartservice.contracts;

import org.bson.types.ObjectId;


public interface IRemoveItemFromCartService {

    /**
     * Remove's an item from cart
     * @param cartId cart's id
     * @param itemId item's id
     * @return true if the item was successfully removed from cart
     */

    boolean removeItem(ObjectId cartId, ObjectId itemId);
}
