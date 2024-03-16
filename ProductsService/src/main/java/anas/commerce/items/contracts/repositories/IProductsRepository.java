package anas.commerce.items.contracts.repositories;


import anas.commerce.items.entities.ProductEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductsRepository extends MongoRepository<ProductEntity, ObjectId> {

    Optional<ProductEntity> findBySupplierProductNumber(String supplierProductNumber);
}
