package anas.commerce.items.contracts;

import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.exception.ItemNotFoundException;
import org.bson.types.ObjectId;


public interface IGetItemByIdService {

    /**
     * @param id item's id
     * @return ItemDto by id
     * */
    ItemDTO getItemById(ObjectId id) throws ItemNotFoundException;

}
