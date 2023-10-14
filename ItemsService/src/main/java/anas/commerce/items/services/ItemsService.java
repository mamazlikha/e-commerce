package anas.commerce.items.services;

import anas.commerce.items.contracts.IItemsRepository;
import anas.commerce.items.contracts.IItemsService;
import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.entities.ItemEntity;
import anas.commerce.items.exception.ItemNotFoundException;
import anas.commerce.items.mappers.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

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

    public ItemDTO getItemById(BigInteger id) throws ItemNotFoundException {
        Optional<ItemEntity> itemOpt = itemsRepository.findById(id);

        if(itemOpt.isPresent()){
            return ItemsMapper.transformerToDto(itemOpt.get());
        }
        throw new ItemNotFoundException("Id invalid");
    }

    @Override
    public void addItem(ItemDTO itemDTO) {
        ItemEntity itemToAdd = new ItemEntity();
        itemToAdd.setPrice(itemDTO.getPrice());
        itemToAdd.setDescription(itemDTO.getDescription());

        this.itemsRepository.save(itemToAdd);
    }

}
