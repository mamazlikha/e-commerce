package anas.commerce.inventoryservice.services;

import anas.commerce.inventoryservice.contracts.IRemoveItemService;
import anas.commerce.inventoryservice.contracts.repositories.IItemsRepository;
import anas.commerce.inventoryservice.entities.ItemEntity;
import anas.commerce.inventoryservice.exceptions.ItemNotFoundException;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RemoveItemService implements IRemoveItemService {

    private final Logger logger = Logger.getLogger(RemoveItemService.class.getName());

    @Autowired
    private IItemsRepository repository;

    @Override
    public Integer decreaseProductQuantity(ObjectId id, ObjectId productId) throws RuntimeException {
        Optional<ItemEntity> itemEntityOptional = repository.findById(id);
        if(itemEntityOptional.isPresent() && itemEntityOptional.get().getProductEntityId() == productId){
            repository.delete(itemEntityOptional.get());
        } else {
            throw new ItemNotFoundException("Item with id : " + id.toHexString() + " does not exist !");
        }
        return repository.findByProductEntityId(productId).size();
    }
}
