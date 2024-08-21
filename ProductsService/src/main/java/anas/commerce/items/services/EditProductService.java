package anas.commerce.items.services;

import anas.commerce.items.contracts.IEditProductService;
import anas.commerce.items.contracts.repositories.IProductsRepository;
import anas.commerce.items.dtos.EditProductDto;
import anas.commerce.items.entities.ProductEntity;
import anas.commerce.items.exceptions.ProductNotFoundException;
import anas.commerce.items.mappers.IProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
@Slf4j
@AllArgsConstructor
public class EditProductService implements IEditProductService {

    private final IProductsRepository repository;

    private final IProductMapper mapper;

    @Override
    public EditProductDto editProduct(EditProductDto newProductDto) throws RuntimeException {
        Optional<ProductEntity> productEntityOptional = repository.findById(new ObjectId(newProductDto.getId()));

        ProductEntity productEntityToUpdate = productEntityOptional.orElseThrow(() -> new ProductNotFoundException("Invalid id: " + newProductDto.getId()));

        ProductEntity newProductEntity = mapper.editProductDtoToProductEntity(newProductDto);
        productEntityToUpdate.setDescription(newProductEntity.getDescription());
        productEntityToUpdate.setSupplierProductNumber(newProductEntity.getSupplierProductNumber());
        productEntityToUpdate.setPrice(newProductEntity.getPrice());
        productEntityToUpdate.setName(newProductEntity.getName());

        return mapper.productEntityToEditProductDto(repository.save(productEntityToUpdate));


    }
}
