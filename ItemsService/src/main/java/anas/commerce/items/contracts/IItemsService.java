package anas.commerce.items.contracts;

import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.exception.ItemNotFoundException;

import java.math.BigInteger;
import java.util.List;

public interface IItemsService {


    /**
     *
     * */
    List<ItemDTO> findAll();

    /**
     *
     * */
    ItemDTO getItemById(BigInteger id) throws ItemNotFoundException;

    /**
     * @return
     */
    ItemDTO addItem(ItemDTO itemDTO) throws Exception;
}
