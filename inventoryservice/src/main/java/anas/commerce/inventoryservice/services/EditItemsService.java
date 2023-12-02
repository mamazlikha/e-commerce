package anas.commerce.inventoryservice.services;

import anas.commerce.inventoryservice.contracts.IEditItemsService;
import anas.commerce.inventoryservice.contracts.repositories.IItemsRepository;
import anas.commerce.inventoryservice.dtos.ItemDto;
import anas.commerce.inventoryservice.entities.ItemEntity;
import anas.commerce.inventoryservice.exceptions.ItemNotFoundException;
import anas.commerce.inventoryservice.mappers.ItemsMapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class EditItemsService implements IEditItemsService {

    private final Logger logger = Logger.getLogger(EditItemsService.class.getName());

    @Autowired
    private IItemsRepository repository;


    @Override
    public ItemDto editItem(ItemDto newItemDto) throws RuntimeException {
        Optional<ItemEntity> itemEntityOptional = repository.findById(new ObjectId(newItemDto.getId()));

        ItemEntity productEntityToUpdate = itemEntityOptional.orElseThrow(() -> new ItemNotFoundException("Invalid id: " + newItemDto.getId()));
        ItemEntity newItemEntity = ItemsMapper.transformerToEntity(newItemDto);

        productEntityToUpdate.setSupplierNumber(newItemEntity.getSupplierNumber());
        productEntityToUpdate.setProductEntityId(newItemEntity.getProductEntityId());

        return ItemsMapper.transformerToDto(repository.save(productEntityToUpdate));
    }
}
