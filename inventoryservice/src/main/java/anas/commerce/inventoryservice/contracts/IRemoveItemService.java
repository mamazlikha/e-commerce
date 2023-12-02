package anas.commerce.inventoryservice.contracts;

import anas.commerce.inventoryservice.exceptions.ItemNotFoundException;
import org.bson.types.ObjectId;

public interface IRemoveItemService {

    /**
     *
     * */
    Integer decreaseProductQuantity(ObjectId id, ObjectId productId) throws RuntimeException;

}
