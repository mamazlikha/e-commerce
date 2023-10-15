package anas.commerce.items.contracts;


import anas.commerce.items.entities.ItemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;


@Repository
public interface IItemsRepository extends MongoRepository<ItemEntity, BigInteger> {

}
