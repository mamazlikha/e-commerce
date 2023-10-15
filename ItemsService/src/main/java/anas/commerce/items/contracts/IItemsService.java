package anas.commerce.items.contracts;

import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.entities.ItemEntity;
import anas.commerce.items.exception.ItemNotFoundException;

import java.math.BigInteger;
import java.util.List;

public interface IItemsService {

    /**
     *
     * */
    void createItem();

    /**
     *
     * */
    List<ItemDTO> findAll();

    /**
     *
     * */
    ItemDTO getItemById(BigInteger id) throws ItemNotFoundException;

    /**
     *
     * */
    void addItem(ItemDTO itemDTO);
}
