package anas.ecommerce.userservice.contracts;

import anas.ecommerce.userservice.dtos.userdto.CreateUserDto;

import java.util.concurrent.CompletableFuture;

public interface IRegisterNewUserService {


    /**
     * Adds a new user
     * @param createUserDto user's required information
     * */
    CompletableFuture<CreateUserDto> registerUser(CreateUserDto createUserDto);
}
