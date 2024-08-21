package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IUpdateUserService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import anas.ecommerce.userservice.dtos.userdto.EditUserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import anas.ecommerce.userservice.mappers.IUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateUserService implements IUpdateUserService {

    private final IUserMapper mapper;

    private final IUserRepository repository;


    @Override
    public EditUserDto updateUserById(EditUserDto editUserDto, ObjectId id) throws UserNotFoundException {

        Optional<UserEntity> userEntityOptional = repository.findById(id);

        if(userEntityOptional.isPresent()){
            EditUserDto updatedUserDto = mapper.userEntityToEditUserDto(userEntityOptional.get());
            updatedUserDto.setId(id.toHexString());
            updatedUserDto.setBirthdate(editUserDto.getBirthdate());
            updatedUserDto.setUserAddressDto(editUserDto.getUserAddressDto());
            updatedUserDto.setLastname(editUserDto.getLastname());
            updatedUserDto.setFirstname(editUserDto.getFirstname());
            updatedUserDto.setPhoneNumber(editUserDto.getPhoneNumber());
            updatedUserDto.setEmail(editUserDto.getEmail());
            return mapper.userEntityToEditUserDto(repository.save(mapper.editUserDtoToUserEntity(updatedUserDto)));
        }
        else {
            throw new UserNotFoundException(id);
        }

    }
}
