package anas.ecommerce.userservice.mappers;

import anas.ecommerce.userservice.dtos.userdto.CreateUserDto;
import anas.ecommerce.userservice.dtos.userdto.EditUserDto;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import org.bson.types.ObjectId;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    @Mapping(source = "id", target = "id", qualifiedByName = "idToString")
    UserDto userEntityToUserDto(UserEntity entity);

    @Mapping(source = "id", target = "id", qualifiedByName = "idToString")
    EditUserDto userEntityToEditUserDto(UserEntity entity);

    @Mapping(source = "id", target = "id", qualifiedByName = "stringToId")
    UserEntity editUserDtoToUserEntity(EditUserDto dto);

    @Mapping(source = "id", target = "id", qualifiedByName = "idToString")
    CreateUserDto createUserEntityToUserDto(UserEntity entity);

    @Mapping(source = "id", target = "id", qualifiedByName = "stringToId")
    UserEntity userEntitiesToCreateUserDtos(CreateUserDto dto);

    @IterableMapping(elementTargetType = UserDto.class)
    List<UserDto> userEntitiesToUserDtos(List<UserEntity> entities);

    @Mapping(source = "id", target = "id", qualifiedByName = "stringToId")
    UserEntity userDtoToUserEntity(UserDto dto);

    @Named("idToString")
    default String idToString(ObjectId id){
        return id.toString();
    }

    @Named("stringToId")
    default ObjectId stringToId(String id){
        return new ObjectId(id);
    }
}
