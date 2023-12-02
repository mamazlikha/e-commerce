package anas.commerce.items.mappers;

import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.entities.ProductEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsMapper {

    public static ProductEntity transformerToEntity(ProductDTO dto){
        ProductEntity result = new ProductEntity();

        result.setDescription(dto.getDescription());
        result.setName(dto.getName());
        result.setId(new ObjectId(dto.getId()));
        result.setSupplierNumber(dto.getSupplierNumber());
        result.setPrice(dto.getPrice());

        return result;
    }

    public static ProductDTO transformerToDto(ProductEntity entity){
        ProductDTO result = new ProductDTO();

        result.setDescription(entity.getDescription());
        result.setName(entity.getName());
        result.setSupplierNumber(entity.getSupplierNumber());
        result.setId(entity.getId().toHexString());
        result.setPrice(entity.getPrice());

        return result;
    }
    public static List<ProductDTO> transformerToDto(List<ProductEntity> entities){
        return entities.stream().map(ProductsMapper::transformerToDto).collect(Collectors.toList());
    }


}
