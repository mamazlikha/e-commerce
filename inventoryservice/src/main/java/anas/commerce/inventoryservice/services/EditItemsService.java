package anas.commerce.inventoryservice.services;

import anas.commerce.inventoryservice.contracts.IEditItemsService;
import anas.commerce.inventoryservice.contracts.repositories.IItemsRepository;
import anas.commerce.inventoryservice.dtos.ItemDto;
import anas.commerce.inventoryservice.entities.ItemEntity;
import anas.commerce.inventoryservice.exceptions.ItemNotFoundException;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class EditItemsService implements IEditItemsService {

    private final Logger logger = Logger.getLogger(EditItemsService.class.getName());

    @Autowired
    private IItemsRepository repository;


    @Autowired
    private ModelMapper mapper;
    @Override
    public ItemDto editItem(ItemDto newItemDto) throws RuntimeException {
        Optional<ItemEntity> itemEntityOptional = repository.findById(new ObjectId(newItemDto.getId()));

        ItemEntity productEntityToUpdate = itemEntityOptional.orElseThrow(() -> new ItemNotFoundException("Invalid id: " + newItemDto.getId()));
        ItemEntity newItemEntity = mapper.map(newItemDto, ItemEntity.class);

        productEntityToUpdate.setSupplierNumber(newItemEntity.getSupplierNumber());
        productEntityToUpdate.setProductEntityId(newItemEntity.getProductEntityId());

        return mapper.map(repository.save(productEntityToUpdate), ItemDto.class);
    }
}
