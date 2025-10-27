package anas.commerce.inventoryservice.services;

import anas.commerce.inventoryservice.contracts.IRemoveItemService;
import anas.commerce.inventoryservice.contracts.repositories.IItemsRepository;
import anas.commerce.inventoryservice.entities.ItemEntity;
import anas.commerce.inventoryservice.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RemoveItemService implements IRemoveItemService {


    private final IItemsRepository repository;

    @Override
    public Integer decreaseProductQuantity(ObjectId id, ObjectId productId) throws RuntimeException {
        Optional<ItemEntity> itemEntityOptional = repository.findById(id);
        if(itemEntityOptional.isPresent() && itemEntityOptional.get().getProductEntityId() == productId){
            repository.delete(itemEntityOptional.get());
        } else {
            throw new ItemNotFoundException("Item with id : " + id.toHexString() + " does not exist !", id.toHexString());
        }
        return repository.findByProductEntityId(productId).size();
    }
}
