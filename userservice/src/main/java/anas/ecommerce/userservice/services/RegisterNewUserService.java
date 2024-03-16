package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IRegisterNewUserService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.CartDto;
import anas.ecommerce.userservice.dtos.userdto.CreateUserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import anas.ecommerce.userservice.exceptions.UserAlreadyExistException;
import anas.ecommerce.userservice.exceptions.UserNotCreatedException;
import anas.ecommerce.userservice.mappers.CreateUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RegisterNewUserService implements IRegisterNewUserService {

    private final Logger logger = Logger.getLogger(RegisterNewUserService.class.getName());

    private final RestTemplate restTemplate;


    @Value("${cartservice.host}")
    private String cartServiceUrl;


    @Value("${cartservice.port}")
    private String cartServicePort;

    @Autowired
    private IUserRepository repository;

    @Autowired
    public RegisterNewUserService(RestTemplateBuilder builder){
        restTemplate = builder.build();
    }

    public CreateUserDto registerUser(CreateUserDto createUserDto) {
        Optional<UserEntity> alreadyExist = repository.findByEmailOrPhoneNumber(createUserDto.getEmail(), createUserDto.getPhoneNumber());
        if(alreadyExist.isEmpty()){
            var response = restTemplate.postForEntity("http://" + cartServiceUrl + ":" + cartServicePort +"/carts/createforuser/", "", CartDto.class); /// TODO replace with a client !

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                createUserDto.setUserCartDto(response.getBody());
                return CreateUserMapper.transformerToDto(repository.save(CreateUserMapper.transformerToEntity(createUserDto)));
            }
            else {
                throw new UserNotCreatedException("Couldn't create user");
            }
        }
        throw new UserAlreadyExistException(createUserDto.getEmail(), createUserDto.getPhoneNumber());
    }
}
