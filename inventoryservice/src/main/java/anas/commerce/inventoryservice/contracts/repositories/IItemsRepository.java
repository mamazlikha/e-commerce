package anas.commerce.inventoryservice.contracts.repositories;

import anas.commerce.inventoryservice.entities.ItemEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IItemsRepository extends MongoRepository<ItemEntity, ObjectId> {

    List<ItemEntity> findByProductEntityId (ObjectId productEntityId);
}
