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
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegisterNewUserService implements IRegisterNewUserService {

    private final IUserMapper mapper;
    @Value("${cartservice.host}")
    private String cartServiceUrl;


    @Value("${cartservice.port}")
    private String cartServicePort;

    @Autowired
    private IUserRepository repository;

    private CreateCartForUserControllerApi createCartForUserControllerApi;


    @PostConstruct
    @Profile("test")
    public void afterInit(){
        ApiClient cartServiceDefaultConfig = Configuration.getDefaultApiClient();
        cartServiceDefaultConfig.setBasePath(cartServiceUrl+":"+cartServicePort);
        this.createCartForUserControllerApi = new CreateCartForUserControllerApi(cartServiceDefaultConfig);
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
