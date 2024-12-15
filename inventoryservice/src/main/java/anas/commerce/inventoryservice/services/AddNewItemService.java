package anas.commerce.inventoryservice.services;

import anas.commerce.inventoryservice.contracts.IAddNewItemService;
import anas.commerce.inventoryservice.contracts.repositories.IItemsRepository;
import anas.commerce.inventoryservice.entities.ItemEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddNewItemService implements IAddNewItemService {


    private final IItemsRepository repository;

    @Override
    public Integer increaseProductQuantity(ObjectId productId, String supplierNumber) {
        repository.save(new ItemEntity(productId, supplierNumber));
        return repository.findByProductEntityId(productId).size();
    }
}
