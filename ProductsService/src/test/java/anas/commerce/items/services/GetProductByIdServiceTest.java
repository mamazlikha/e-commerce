package anas.commerce.items.services;

import anas.commerce.items.contracts.repositories.IProductsRepository;
import anas.commerce.items.dtos.EditProductDto;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.entities.ProductEntity;
import anas.commerce.items.exceptions.ProductNotFoundException;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GetProductByIdServiceTest {

    @Autowired
    GetProductByIdService service;

    @MockBean
    IProductsRepository repository;

    @Test
    public void getProductById_should_return(){
        // Arrange
        String objectId = "68ea1111279ffadb9adb840d";
        ProductEntity entity = new ProductEntity(new ObjectId(objectId), "14erz15zer56kj23", "description test", "name 1",43.2d);
        when(repository.findById(any())).thenReturn(Optional.of(entity));

        // Act
        ProductDTO result = service.getProductById(new ObjectId(objectId));

        // Assert
        assertEquals(entity.getName(), result.getName());
        assertEquals(entity.getDescription(), result.getDescription());
        assertEquals(entity.getPrice(), result.getPrice(), 0.01);
    }

    @Test
    public void getProductById_should_throw_ifEntityNotExist(){
        // Arrange
        String objectId = "68ea1111279ffadb9adb840d";
        when(repository.findById(any())).thenReturn(Optional.empty());

        // Act
        ProductNotFoundException productNotFoundException =  assertThrows(ProductNotFoundException.class, () -> {
            service.getProductById(new ObjectId(objectId));
        });

        // Assert
        assertEquals(objectId, productNotFoundException.getProductId());
    }
}
