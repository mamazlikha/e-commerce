package anas.commerce.items.services;

import anas.commerce.items.contracts.IFindAllProductsService;
import anas.commerce.items.contracts.repositories.IProductsRepository;
import anas.commerce.items.dtos.EditProductDto;
import anas.commerce.items.dtos.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class FindAllProductsService implements IFindAllProductsService {

    private final Logger logger = Logger.getLogger(FindAllProductsService.class.getName());

    @Autowired
    private IProductsRepository itemsRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> result = new ArrayList<>();
        itemsRepository.findAll().forEach(x -> result.add(mapper.map(x, EditProductDto.class)));
        return result;
    }

}
