package anas.commerce.inventoryservice.contracts;

import anas.commerce.inventoryservice.dtos.ItemDto;

public interface IEditItemsService {

    /**
     *
     * */
    ItemDto editItem(ItemDto newItemDto) throws RuntimeException;
}
