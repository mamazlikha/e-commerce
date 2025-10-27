package anas.commerce.items.services;

import anas.commerce.items.contracts.IDeleteProductByIdService;
import anas.commerce.items.contracts.repositories.IProductsRepository;
import anas.commerce.items.entities.ProductEntity;
import anas.commerce.items.mappers.IProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class DeleteProductByIdService implements IDeleteProductByIdService {

    private final IProductsRepository productsRepository;

    @Override
    public boolean deleteById(ObjectId id) {
        Optional<ProductEntity> itemOpt = productsRepository.findById(id);
        if(itemOpt.isPresent()){
            // TODO call ItemService to remove all items associated with this product
            productsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
