package anas.commerce.items.services;

import anas.commerce.items.contracts.IItemsRepository;
import anas.commerce.items.contracts.IItemsService;
import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.entities.ItemEntity;
import anas.commerce.items.exception.ItemNotFoundException;
import anas.commerce.items.mappers.ItemMapper;
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
    public List<ItemDTO> findAll() {
        return ItemMapper.transformerToDto(itemsRepository.findAll());
    }

    public ItemDTO getItemById(BigInteger id) throws ItemNotFoundException {
        Optional<ItemEntity> itemOpt = itemsRepository.findById(id);

        if(itemOpt.isPresent()){
            return ItemMapper.transformerToDto(itemOpt.get());
        }
        throw new ItemNotFoundException("Id invalid");
    }

    @Override
    public ItemDTO addItem(ItemDTO itemDTO) throws Exception {
        ItemEntity itemToAdd = ItemMapper.transformerToEntity(itemDTO);

        return ItemMapper.transformerToDto(itemsRepository.save(itemToAdd));
    }

}
