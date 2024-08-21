package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IGetUserByIdService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import anas.ecommerce.userservice.mappers.IUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetUserByIdService implements IGetUserByIdService {

    private final IUserMapper mapper;

    private final IUserRepository repository;

    @Override
    public UserDto getUserById(ObjectId id) throws RuntimeException {
        return mapper.userEntityToUserDto(repository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }
}
