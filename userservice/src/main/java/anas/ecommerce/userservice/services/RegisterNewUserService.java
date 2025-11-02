package anas.ecommerce.userservice.services;

import anas.ecommerce.client.ApiClient;
import anas.ecommerce.client.ApiException;
import anas.ecommerce.client.Configuration;
import anas.ecommerce.client.api.CreateCartForUserControllerApi;
import anas.ecommerce.client.model.CartDto;
import anas.ecommerce.userservice.contracts.IRegisterNewUserService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.userdto.CreateUserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import anas.ecommerce.userservice.exceptions.UserAlreadyExistException;
import anas.ecommerce.userservice.mappers.IUserMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class RegisterNewUserService implements IRegisterNewUserService {

    private final IUserMapper mapper;

    private final IUserRepository repository;

    @Setter
    private CreateCartForUserControllerApi createCartForUserControllerApi;


    @Autowired
    public RegisterNewUserService(IUserMapper mapper, IUserRepository repository, CreateCartForUserControllerApi createCartForUserControllerApi){
        this.mapper = mapper;
        this.repository = repository;
        this.createCartForUserControllerApi = createCartForUserControllerApi;
    }

    @Async
    public CompletableFuture<CreateUserDto> registerUser(CreateUserDto createUserDto) {
        Optional<UserEntity> alreadyExist = repository.findByEmailOrPhoneNumber(createUserDto.getEmail(), createUserDto.getPhoneNumber());
        if(alreadyExist.isEmpty()){
            CartDto response;

            try {
                response = createCartForUserControllerApi.createCartForUser();
            } catch (ApiException e) {
                throw new RuntimeException(e);
            }
            createUserDto.setUserCartDto(response);
            CreateUserDto savedUser = mapper.createUserEntityToUserDto(repository.save(mapper.userDtoToUserEntity(createUserDto)));
            return CompletableFuture.completedFuture(savedUser);

        }
        throw new UserAlreadyExistException(createUserDto.getEmail(), createUserDto.getPhoneNumber());
    }
}
