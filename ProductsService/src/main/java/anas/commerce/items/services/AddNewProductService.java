package anas.commerce.items.services;

import anas.commerce.items.contracts.IAddNewProductService;
import anas.commerce.items.contracts.repositories.IProductsRepository;
import anas.commerce.items.dtos.CreateProductDto;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.entities.ProductEntity;
import anas.commerce.items.exceptions.ProductAlreadyExistException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AddNewProductService implements IAddNewProductService {

    private final Logger logger = Logger.getLogger(AddNewProductService.class.getName());

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IProductsRepository itemsRepository;

    @Override
    public ProductDTO addNewProduct(CreateProductDto createProductDTO) throws RuntimeException {
        Optional<ProductEntity> alreadyExist = itemsRepository.findBySupplierProductNumber(createProductDTO.getSupplierProductNumber());
        if(alreadyExist.isPresent()){
            throw new ProductAlreadyExistException(createProductDTO.getSupplierProductNumber());
        }
        return mapper.map(itemsRepository.save(mapper.map(createProductDTO, ProductEntity.class)), ProductDTO.class);
    }

}
