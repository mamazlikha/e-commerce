package anas.commerce.inventoryservice.services;

import anas.commerce.inventoryservice.contracts.IEditItemsService;
import anas.commerce.inventoryservice.contracts.repositories.IItemsRepository;
import anas.commerce.inventoryservice.dtos.ItemDto;
import anas.commerce.inventoryservice.entities.ItemEntity;
import anas.commerce.inventoryservice.exceptions.ItemNotFoundException;
import anas.commerce.inventoryservice.mappers.IItemMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class EditItemsService implements IEditItemsService {


    private final IItemsRepository repository;

    private final IItemMapper mapper;

    @Override
    public ItemDto editItem(ItemDto newItemDto) throws RuntimeException {
        Optional<ItemEntity> itemEntityOptional = repository.findById(new ObjectId(newItemDto.getId()));

        ItemEntity productEntityToUpdate = itemEntityOptional.orElseThrow(() -> new ItemNotFoundException("Invalid id: " + newItemDto.getId()));
        ItemEntity newItemEntity = mapper.itemDtoToItemEntity(newItemDto);

        productEntityToUpdate.setSupplierNumber(newItemEntity.getSupplierNumber());
        productEntityToUpdate.setProductEntityId(newItemEntity.getProductEntityId());

        return mapper.itemEntityToItemDto(repository.save(productEntityToUpdate));
    }
}
