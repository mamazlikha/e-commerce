package anas.commerce.items.services;

import anas.commerce.items.contracts.IFindAllProductsService;
import anas.commerce.items.contracts.repositories.IProductsRepository;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.mappers.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class FindAllProductsService implements IFindAllProductsService {

    private final Logger logger = Logger.getLogger(FindAllProductsService.class.getName());

    @Autowired
    private IProductsRepository itemsRepository;


    @Override
    public List<ProductDTO> findAll() {
        return ProductsMapper.transformerToDto(itemsRepository.findAll());
    }

}
