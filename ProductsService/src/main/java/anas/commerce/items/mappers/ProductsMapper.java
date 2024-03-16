package anas.commerce.items.mappers;

import anas.commerce.items.dtos.CreateProductDto;
import anas.commerce.items.dtos.EditProductDto;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.entities.ProductEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsMapper {

    public static ProductEntity transformerToEntity(CreateProductDto dto){
        ProductEntity result = new ProductEntity();

        result.setDescription(dto.getDescription());
        result.setName(dto.getName());
        result.setSupplierProductNumber(dto.getSupplierProductNumber());
        result.setPrice(dto.getPrice());

        return result;
    }

    public static ProductEntity transformerToEntity(EditProductDto dto){
        ProductEntity result = new ProductEntity();

        result.setDescription(dto.getDescription());
        result.setId(new ObjectId(dto.getId()));
        result.setName(dto.getName());
        result.setSupplierProductNumber(dto.getSupplierProductNumber());
        result.setPrice(dto.getPrice());

        return result;
    }

    public static EditProductDto transformerToDto(ProductEntity entity){
        EditProductDto result = new EditProductDto();

        result.setDescription(entity.getDescription());
        result.setName(entity.getName());
        result.setId(entity.getId().toHexString());
        result.setSupplierProductNumber(entity.getSupplierProductNumber());
        result.setPrice(entity.getPrice());

        return result;
    }
    public static List<ProductDTO> transformerToDto(List<ProductEntity> entities){
        return entities.stream().map(ProductsMapper::transformerToDto).collect(Collectors.toList());
    }


}
