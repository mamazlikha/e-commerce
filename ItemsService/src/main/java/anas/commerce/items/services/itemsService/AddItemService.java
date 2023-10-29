package anas.commerce.items.services.itemsService;

import anas.commerce.items.contracts.repositories.IItemsRepository;
import anas.commerce.items.contracts.itemsService.IAddItemService;
import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.entities.ItemEntity;
import anas.commerce.items.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AddItemService implements IAddItemService {

    private final Logger logger = Logger.getLogger(AddItemService.class.getName());

    @Autowired
    private IItemsRepository itemsRepository;

    @Override
    public ItemDTO addItem(ItemDTO itemDTO) throws Exception {
        ItemEntity itemToAdd = ItemMapper.transformerToEntity(itemDTO);

        return ItemMapper.transformerToDto(itemsRepository.save(itemToAdd));
    }

}
