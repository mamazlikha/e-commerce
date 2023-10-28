package anas.commerce.items.contracts.itemsService;

import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.exception.ItemNotFoundException;

import java.math.BigInteger;

public interface IGetItemByIdService {

    /**
     * @param id item's id
     * @return ItemDto by id
     * */
    ItemDTO getItemById(BigInteger id) throws ItemNotFoundException;

}
