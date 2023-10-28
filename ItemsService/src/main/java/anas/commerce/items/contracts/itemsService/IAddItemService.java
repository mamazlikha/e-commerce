package anas.commerce.items.contracts.itemsService;

import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.exception.ItemNotFoundException;

import java.math.BigInteger;
import java.util.List;

public interface IAddItemService {


    /**
     * @param itemDTO item to add
     * @return ItemDto
     */
    ItemDTO addItem(ItemDTO itemDTO) throws Exception;
}
