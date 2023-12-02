package anas.commerce.items.contracts;

import org.bson.types.ObjectId;

public interface IAddNewItemService {


    /**
     *
     * @param
     * */
    void increaseProductQuantity(ObjectId productId, ObjectId supplierNumber);

}
