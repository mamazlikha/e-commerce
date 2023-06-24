package anas.commerce.items.contracts;


import anas.commerce.items.entities.ItemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IItemsRepository extends MongoRepository<ItemEntity, Long> {

    public Optional<ItemEntity> findById(Long id);
}
