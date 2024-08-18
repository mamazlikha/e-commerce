package anas.commerce.items.services;

import anas.commerce.items.contracts.IGetProductByIdService;
import anas.commerce.items.contracts.repositories.IProductsRepository;
import anas.commerce.items.dtos.EditProductDto;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.entities.ProductEntity;
import anas.commerce.items.exceptions.ProductNotFoundException;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class GetProductByIdService implements IGetProductByIdService {

    private final Logger logger = Logger.getLogger(GetProductByIdService.class.getName());

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IProductsRepository itemsRepository;

    @Override
    public ProductDTO getProductById(ObjectId id) throws ProductNotFoundException {
        Optional<ProductEntity> itemOpt = itemsRepository.findById(id);

        if(itemOpt.isPresent()){
            return mapper.map(itemOpt.get(), EditProductDto.class);
        }
        throw new ProductNotFoundException("Invalid id : " + id.toHexString());
    }
}
