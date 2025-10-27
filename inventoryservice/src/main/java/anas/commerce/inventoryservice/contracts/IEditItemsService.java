package anas.commerce.inventoryservice.contracts;

import anas.commerce.inventoryservice.dtos.ItemDto;

public interface IEditItemsService {

    /**
     *
     * @param newItemDto
     * @return ItemDto
     * @throws RuntimeException
     */
    ItemDto editItem(ItemDto newItemDto) throws RuntimeException;
}
