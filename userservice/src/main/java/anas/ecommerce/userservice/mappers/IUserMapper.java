package anas.ecommerce.userservice.mappers;

import anas.ecommerce.userservice.dtos.userdto.CreateUserDto;
import anas.ecommerce.userservice.dtos.userdto.EditUserDto;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import anas.ecommerce.userservice.entities.UserEntity;
import org.bson.types.ObjectId;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = IUserAddress.class)
public interface IUserMapper {

    @Mapping(source = "id", target = "id", qualifiedByName = "idToString")
    @Mapping(target = "userAddressDto", source = "address")
    UserDto entityToDto(UserEntity entity);

    @Mapping(source = "id", target = "id", qualifiedByName = "idToString")
    @Mapping(target = "userAddressDto", source = "address")
    EditUserDto userEntityToEditUserDto(UserEntity entity);

    @Mapping(source = "id", target = "id", qualifiedByName = "stringToId")
    @Mapping(target = "address", source = "userAddressDto")
    UserEntity editUserDtoToUserEntity(EditUserDto dto);

    @Mapping(source = "id", target = "id", qualifiedByName = "idToString")
    @Mapping(target = "userAddressDto", source = "address")
    CreateUserDto createUserEntityToUserDto(UserEntity entity);

    @Mapping(source = "id", target = "id", qualifiedByName = "stringToId")
    @Mapping(target = "address", source = "userAddressDto")
    UserEntity userEntitiesToCreateUserDtos(CreateUserDto dto);

    @IterableMapping(elementTargetType = UserDto.class)
    List<UserDto> userEntitiesToUserDtos(List<UserEntity> entities);

    @Mapping(source = "id", target = "id", qualifiedByName = "stringToId", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(target = "address", source = "userAddressDto")
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
