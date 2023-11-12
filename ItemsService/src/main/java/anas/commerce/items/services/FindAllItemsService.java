package anas.commerce.items.services;

import anas.commerce.items.contracts.IFindAllItemsService;
import anas.commerce.items.contracts.repositories.IItemsRepository;
import anas.commerce.items.dtos.ItemDTO;
import anas.commerce.items.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class FindAllItemsService implements IFindAllItemsService {

    private final Logger logger = Logger.getLogger(FindAllItemsService.class.getName());

    @Autowired
    private IItemsRepository itemsRepository;


    @Override
    public List<ItemDTO> findAll() {
        return ItemMapper.transformerToDto(itemsRepository.findAll());
    }

}
