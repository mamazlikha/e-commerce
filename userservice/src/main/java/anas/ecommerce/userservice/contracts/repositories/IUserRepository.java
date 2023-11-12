package anas.ecommerce.userservice.contracts.repositories;

import anas.ecommerce.userservice.entities.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IUserRepository extends MongoRepository<UserEntity, ObjectId> {


    Optional<UserEntity> findByEmailOrPhoneNumber(String email, String phoneNumber);
}
