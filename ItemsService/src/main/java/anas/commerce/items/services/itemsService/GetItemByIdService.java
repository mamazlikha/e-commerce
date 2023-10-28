package anas.commerce.items.services.itemsService;

import anas.commerce.items.contracts.itemsService.IGetItemByIdService;
import anas.commerce.items.contracts.repositories.IItemsRepository;
import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.entities.ItemEntity;
import anas.commerce.items.exception.ItemNotFoundException;
import anas.commerce.items.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class GetItemByIdService implements IGetItemByIdService {


    @Autowired
    private IItemsRepository itemsRepository;

    @Override
    public ItemDTO getItemById(BigInteger id) throws ItemNotFoundException {
        Optional<ItemEntity> itemOpt = itemsRepository.findById(id);

        if(itemOpt.isPresent()){
            return ItemMapper.transformerToDto(itemOpt.get());
        }
        throw new ItemNotFoundException("Id invalid");
    }
}
