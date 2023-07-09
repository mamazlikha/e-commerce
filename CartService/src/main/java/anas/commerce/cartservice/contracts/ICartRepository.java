package anas.commerce.cartservice.contracts;

import anas.commerce.cartservice.entities.CartEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface ICartRepository extends MongoRepository<CartEntity, BigInteger> {
}
