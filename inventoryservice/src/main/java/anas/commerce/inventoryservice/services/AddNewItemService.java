package anas.commerce.inventoryservice.services;

import anas.commerce.inventoryservice.contracts.IAddNewItemService;
import anas.commerce.inventoryservice.contracts.repositories.IItemsRepository;
import anas.commerce.inventoryservice.entities.ItemEntity;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AddNewItemService implements IAddNewItemService {

    private final Logger logger = Logger.getLogger(AddNewItemService.class.getName());

    @Autowired
    private IItemsRepository repository;

    @Override
    public Integer increaseProductQuantity(ObjectId productId, String supplierNumber) {
        repository.save(new ItemEntity(productId, supplierNumber));
        return repository.findByProductEntityId(productId).size();
    }
}
