package anas.commerce.inventoryservice.contracts;

import org.bson.types.ObjectId;

public interface IAddNewItemService {


    /**
     *
     * @param
     * */
    Integer increaseProductQuantity(ObjectId productId, String supplierNumber);

}
