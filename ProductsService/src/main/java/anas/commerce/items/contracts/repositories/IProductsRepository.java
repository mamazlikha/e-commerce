package anas.commerce.items.contracts.repositories;


import anas.commerce.items.entities.ProductEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductsRepository extends MongoRepository<ProductEntity, ObjectId> {

}
