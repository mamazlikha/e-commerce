package anas.commerce.items.contracts;


import anas.commerce.items.entities.ItemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;


public interface IItemsRepository extends MongoRepository<ItemEntity, BigInteger> {

}
