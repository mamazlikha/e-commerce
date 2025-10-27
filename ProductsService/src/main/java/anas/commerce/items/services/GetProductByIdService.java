package anas.commerce.items.services;

import anas.commerce.items.contracts.IGetProductByIdService;
import anas.commerce.items.contracts.repositories.IProductsRepository;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.entities.ProductEntity;
import anas.commerce.items.exceptions.ProductNotFoundException;
import anas.commerce.items.mappers.IProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetProductByIdService implements IGetProductByIdService {

    private final IProductMapper mapper;

    private final IProductsRepository productsRepository;

    @Override
    public ProductDTO getProductById(ObjectId id) throws ProductNotFoundException {
        Optional<ProductEntity> itemOpt = productsRepository.findById(id);

        if(itemOpt.isPresent()){
            return mapper.productEntityToProductDto(itemOpt.get());
        }
        throw new ProductNotFoundException("Invalid id : " + id.toHexString(), id.toHexString());
    }
}
