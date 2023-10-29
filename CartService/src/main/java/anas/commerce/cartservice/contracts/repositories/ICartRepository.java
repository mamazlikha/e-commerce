package anas.commerce.cartservice.contracts.repositories;

import anas.commerce.cartservice.entities.CartEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICartRepository extends MongoRepository<CartEntity, ObjectId> {


}
