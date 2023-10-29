package anas.commerce.items.contracts.repositories;


import anas.commerce.items.entities.ItemEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IItemsRepository extends MongoRepository<ItemEntity, ObjectId> {

}
