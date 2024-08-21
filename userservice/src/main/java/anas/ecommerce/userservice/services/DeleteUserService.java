package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IDeleteUserService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.entities.UserEntity;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteUserService implements IDeleteUserService {

    private final IUserRepository repository;


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
