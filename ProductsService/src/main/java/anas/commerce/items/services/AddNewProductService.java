package anas.commerce.items.services;

import anas.commerce.items.contracts.IAddNewProductService;
import anas.commerce.items.contracts.repositories.IProductsRepository;
import anas.commerce.items.dtos.CreateProductDto;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.entities.ProductEntity;
import anas.commerce.items.exceptions.ProductAlreadyExistException;
import anas.commerce.items.mappers.IProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class AddNewProductService implements IAddNewProductService {

    private final IProductMapper mapper;

    private final IProductsRepository itemsRepository;

    @Override
    public ProductDTO addNewProduct(CreateProductDto createProductDTO) throws RuntimeException {
        Optional<ProductEntity> alreadyExist = itemsRepository.findBySupplierProductNumber(createProductDTO.getSupplierProductNumber());
        if(alreadyExist.isPresent()){
            throw new ProductAlreadyExistException(createProductDTO.getSupplierProductNumber());
        }
        return mapper.productEntityToEditProductDto(itemsRepository.save(mapper.productDtoToProductEntity(createProductDTO)));
    }

}
