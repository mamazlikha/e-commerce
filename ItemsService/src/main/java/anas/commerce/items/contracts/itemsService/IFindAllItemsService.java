package anas.commerce.items.contracts.itemsService;

import anas.commerce.items.dtos.ItemDTO;

import java.util.List;

public interface IFindAllItemsService {



    /**
     * @return List of ItemDto in the database
     * */
    List<ItemDTO> findAll();

}
