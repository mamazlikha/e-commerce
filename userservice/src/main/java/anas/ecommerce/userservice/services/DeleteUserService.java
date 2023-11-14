package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.contracts.IDeleteUserService;
import anas.ecommerce.userservice.entities.UserEntity;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUserService implements IDeleteUserService {


    @Autowired
    private IUserRepository repository;


    @Override
    public void deleteUser(ObjectId userId) {
        Optional<UserEntity> userToDeleteOpt = repository.findById(userId);

        if(userToDeleteOpt.isPresent()){
            repository.delete(userToDeleteOpt.get());
        }
        else {
            throw new UserNotFoundException(userId);
        }
    }
}
