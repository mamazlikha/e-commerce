package anas.commerce.items.contracts;

import anas.commerce.items.dtos.ItemDTO;

public interface IAddItemService {


    /**
     * @param itemDTO item to add
     * @return ItemDto
     */
    ItemDTO addItem(ItemDTO itemDTO) throws Exception;
}
