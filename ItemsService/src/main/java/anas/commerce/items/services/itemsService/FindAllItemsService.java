package anas.commerce.items.services.itemsService;

import anas.commerce.items.contracts.itemsService.IFindAllItemsService;
import anas.commerce.items.contracts.repositories.IItemsRepository;
import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllItemsService implements IFindAllItemsService {

    @Autowired
    private IItemsRepository itemsRepository;


    @Override
    public List<ItemDTO> findAll() {
        return ItemMapper.transformerToDto(itemsRepository.findAll());
    }

}
