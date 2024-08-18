package anas.ecommerce.userservice.configurations;

import anas.ecommerce.userservice.dtos.userdto.CreateUserDto;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import anas.ecommerce.userservice.entities.CartEntity;
import anas.ecommerce.userservice.entities.UserEntity;
import jakarta.annotation.PostConstruct;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.openapitools.client.model.CartDto;
import org.openapitools.client.model.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class MapperConfiguration {

    @Autowired
    private ModelMapper modelMapper;

    @PostConstruct
    public void configureModelMapper() {
        TypeMap<UserEntity, UserDto> getUserMap = modelMapper.createTypeMap(UserEntity.class, UserDto.class);
        getUserMap.addMapping(UserEntity::getAddress, UserDto::setUserAddressDto);

        TypeMap<UserEntity, CreateUserDto> createUserMap = modelMapper.createTypeMap(UserEntity.class, CreateUserDto.class);
        createUserMap.addMapping(UserEntity::getAddress, CreateUserDto::setUserAddressDto);
        createUserMap.addMapping(UserEntity::getUserCart, CreateUserDto::setUserCartDto);

        TypeMap<CartEntity, CartDto> cartMap = modelMapper.createTypeMap(CartEntity.class, CartDto.class);
        cartMap.addMappings(x -> {
            Converter<CartEntity, CartDto> converter = new AbstractConverter<CartEntity, CartDto>() {
                @Override
                protected CartDto convert(CartEntity cartEntity) {
                    CartDto dto = new CartDto();
                    Set<ItemDTO> itemDTOSet = new HashSet<>();
                    cartEntity.getItems().forEach(itemEntity -> {
                        ItemDTO itemDTO = new ItemDTO();
                        itemDTO.setId(itemEntity.getId().toHexString());
                        itemDTO.setSupplierNumber(itemEntity.getSupplierNumber());
                        itemDTO.setProductEntityId(itemEntity.getProductEntityId().toHexString());
                        itemDTOSet.add(itemDTO);
                    });
                    dto.setItemsDto(itemDTOSet);
                    dto.setId(cartEntity.getId().toHexString());
                    dto.setTotalPrice(cartEntity.getTotalPrice());
                    return dto;
                }
            };
            x.using(converter);
        });

    }
}
