package anas.commerce.inventoryservice.contracts;

import org.bson.types.ObjectId;

public interface IAddNewItemService {


    /**
     *
     * @param productId
     * @return true if item was successfully added to data base
     */
    boolean increaseProductQuantity(ObjectId productId);

}
