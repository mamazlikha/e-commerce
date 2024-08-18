package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IRegisterNewUserService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.userdto.CreateUserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import anas.ecommerce.userservice.exceptions.UserAlreadyExistException;
import anas.ecommerce.userservice.exceptions.UserNotCreatedException;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.CreateCartForUserControllerApi;
import org.openapitools.client.model.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class RegisterNewUserService implements IRegisterNewUserService {

    private final ModelMapper mapper;
    @Value("${cartservice.host}")
    private String cartServiceUrl;


    @Value("${cartservice.port}")
    private String cartServicePort;

    @Autowired
    private IUserRepository repository;

    private CreateCartForUserControllerApi createCartForUserControllerApi;

    @Autowired
    public RegisterNewUserService(ModelMapper modelMapper){
        mapper = modelMapper;
    }

    @PostConstruct
    @Profile("test")
    public void afterInit(){
        this.createCartForUserControllerApi = new CreateCartForUserControllerApi();
        this.createCartForUserControllerApi.setCustomBaseUrl("http://"+cartServiceUrl+":"+cartServicePort);
        log.info("this.createCartForUserControllerApi.getCustomBaseUrl() === "+ this.createCartForUserControllerApi.getCustomBaseUrl());
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
            CreateUserDto savedUser = mapper.map(repository.save(mapper.map(createUserDto, UserEntity.class)), CreateUserDto.class);
            return CompletableFuture.completedFuture(mapper.map(savedUser, CreateUserDto.class));

        }
        throw new UserAlreadyExistException(createUserDto.getEmail(), createUserDto.getPhoneNumber());
    }
}
