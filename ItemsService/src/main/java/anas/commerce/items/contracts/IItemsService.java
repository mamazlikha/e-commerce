package anas.commerce.items.contracts;

import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.entities.ItemEntity;

import java.util.List;

public interface IItemsService {
    public void createItem();

    List<ItemEntity> findAll();
}
