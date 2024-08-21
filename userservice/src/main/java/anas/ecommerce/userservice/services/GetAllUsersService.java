package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IGetAllUsersService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import anas.ecommerce.userservice.mappers.IUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetAllUsersService implements IGetAllUsersService {

    private final IUserRepository repository;

    private final IUserMapper mapper;

    @Override
    public List<UserDto> getAllUsers() {
        return mapper.userEntitiesToUserDtos(repository.findAll());
    }
}
