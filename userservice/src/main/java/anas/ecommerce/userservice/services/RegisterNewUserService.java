package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IRegisterNewUserService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.CartDto;
import anas.ecommerce.userservice.dtos.UserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import anas.ecommerce.userservice.exceptions.UserAlreadyExistException;
import anas.ecommerce.userservice.exceptions.UserNotCreatedException;
import anas.ecommerce.userservice.mappers.UserMapper;
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

    public UserDto registerUser(UserDto userDto) {
        Optional<UserEntity> alreadyExist = repository.findByEmailOrPhoneNumber(userDto.getEmail(), userDto.getPhoneNumber());
        if(alreadyExist.isEmpty()){
            var response = restTemplate.postForEntity("http://" + cartServiceUrl + ":" + cartServicePort +"/carts/createforuser/", "", CartDto.class); /// TODO replace with a client !

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                userDto.setUserCartDto(response.getBody());
                return UserMapper.transformerToDto(repository.save(UserMapper.transformerToEntity(userDto)));
            }
            else {
                throw new UserNotCreatedException("Couldn't create user");
            }
        }
        throw new UserAlreadyExistException(userDto.getEmail(), userDto.getPhoneNumber());
    }
}
