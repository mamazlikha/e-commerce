package anas.commerce.items.services;

import anas.commerce.items.contracts.IFindAllProductsService;
import anas.commerce.items.contracts.repositories.IProductsRepository;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.mappers.IProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class FindAllProductsService implements IFindAllProductsService {


    private final IProductsRepository itemsRepository;

    private final IProductMapper mapper;


    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> result = new ArrayList<>();
        itemsRepository.findAll().forEach(x -> result.add(mapper.productEntityToEditProductDto(x)));
        return result;
    }

}
