package anas.commerce.items.services;

import anas.commerce.items.contracts.IItemsRepository;
import anas.commerce.items.contracts.IItemsService;
import anas.commerce.items.entities.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService implements IItemsService {

    @Autowired
    private IItemsRepository itemsRepository;

    @Override
    public void createItem() {
    }

    @Override
    public List<ItemEntity> findAll() {
        return itemsRepository.findAll();
    }

}
