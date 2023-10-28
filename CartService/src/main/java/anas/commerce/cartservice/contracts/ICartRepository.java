package anas.commerce.cartservice.contracts;

import anas.commerce.cartservice.entities.CartEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ICartRepository extends MongoRepository<CartEntity, BigInteger> {


}
