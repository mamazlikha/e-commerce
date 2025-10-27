package anas.commerce.inventoryservice.contracts;

import anas.commerce.inventoryservice.dtos.ItemDto;
import org.bson.types.ObjectId;

public interface IGetItemByProductIdService {

    /**
     * Gets an item of a product from database by it's product id
     * @param id product's id
     * @return ItemDto
     */
    ItemDto getItemByProductId(ObjectId id) throws RuntimeException;
}
