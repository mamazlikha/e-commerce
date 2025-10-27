package anas.commerce.inventoryservice.services;

import anas.commerce.inventoryservice.contracts.IGetItemByProductIdService;
import anas.commerce.inventoryservice.contracts.repositories.IItemsRepository;
import anas.commerce.inventoryservice.dtos.ItemDto;
import anas.commerce.inventoryservice.entities.ItemEntity;
import anas.commerce.inventoryservice.exceptions.EmptyItemsForProductException;
import anas.commerce.inventoryservice.exceptions.ItemNotFoundException;
import anas.commerce.inventoryservice.mappers.IItemMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetItemByProductIdService implements IGetItemByProductIdService {
    private final IItemsRepository repository;
    private final IItemMapper mapper;

    @Override
    public ItemDto getItemByProductId(ObjectId id) throws RuntimeException {
        List<ItemEntity> itemsOfProduct = repository.findByProductEntityId(id);
        if(!itemsOfProduct.isEmpty()){
            return mapper.itemEntityToItemDto(itemsOfProduct.get(0));
        }
        throw new EmptyItemsForProductException("No items for product id " + id, id);
    }
}
