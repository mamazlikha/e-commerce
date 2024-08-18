package anas.commerce.items.services;

import anas.commerce.items.contracts.IEditProductService;
import anas.commerce.items.contracts.repositories.IProductsRepository;
import anas.commerce.items.dtos.EditProductDto;
import anas.commerce.items.entities.ProductEntity;
import anas.commerce.items.exceptions.ProductNotFoundException;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class EditProductService implements IEditProductService {

    private final Logger logger = Logger.getLogger(EditProductService.class.getName());


    @Autowired
    private IProductsRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public EditProductDto editProduct(EditProductDto newProductDto) throws RuntimeException {
        Optional<ProductEntity> productEntityOptional = repository.findById(new ObjectId(newProductDto.getId()));

        ProductEntity productEntityToUpdate = productEntityOptional.orElseThrow(() -> new ProductNotFoundException("Invalid id: " + newProductDto.getId()));

        ProductEntity newProductEntity = mapper.map(newProductDto, ProductEntity.class);
        productEntityToUpdate.setDescription(newProductEntity.getDescription());
        productEntityToUpdate.setSupplierProductNumber(newProductEntity.getSupplierProductNumber());
        productEntityToUpdate.setPrice(newProductEntity.getPrice());
        productEntityToUpdate.setName(newProductEntity.getName());

        return mapper.map(repository.save(productEntityToUpdate), EditProductDto.class);


    }
}
