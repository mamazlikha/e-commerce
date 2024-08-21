package anas.commerce.items.mappers;

import anas.commerce.items.dtos.CreateProductDto;
import anas.commerce.items.dtos.EditProductDto;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.entities.ProductEntity;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    ProductDTO productEntityToProductDto(ProductEntity entity);
    @Mapping(source = "id", target = "id", qualifiedByName = "idToString")
    EditProductDto productEntityToEditProductDto(ProductEntity entity);
    CreateProductDto productEntityToCreateProductDto(ProductEntity entity);

    ProductEntity productDtoToProductEntity(ProductDTO dto);
    @Mapping(source = "id", target = "id", qualifiedByName = "stringToId")
    ProductEntity editProductDtoToProductEntity(EditProductDto dto);
    ProductEntity createProductDtoToProductEntity(CreateProductDto dto);

    @Named("idToString")
    default String idToString(ObjectId id){
        return id.toString();
    }

    @Named("stringToId")
    default ObjectId stringToId(String id){
        return new ObjectId(id);
    }
}
