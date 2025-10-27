package anas.commerce.items.services;

import anas.commerce.items.contracts.repositories.IProductsRepository;
import anas.commerce.items.dtos.EditProductDto;
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
public class EditProductServiceTest {

    @Autowired
    EditProductService service;

    @MockBean
    IProductsRepository repository;

    @Test
    public void editProduct_should_editProduct(){
        // Arrange
        String objectId = "68ea2deefcc02c72f4663560";
        String supplierNumber = "0132dsfqqfsd10ds23q";
        double price = 15.2d;
        double newPrice = 16.0d;
        String name = "Pampers";
        String description = "Confort for child";
        EditProductDto newProductModifiedDto = new EditProductDto(objectId, supplierNumber, newPrice, name, description);
        ProductEntity newEntity = new ProductEntity(new ObjectId(objectId), supplierNumber, description, name, newPrice);
        ProductEntity existingEntityToEdit = new ProductEntity(new ObjectId(objectId), supplierNumber, description, name, price);

        when(repository.findById(any())).thenReturn(Optional.of(existingEntityToEdit));
        when(repository.save(any())).thenReturn(newEntity);

        // Act
        EditProductDto result = service.editProduct(newProductModifiedDto);

        // Assert
        assertEquals(newPrice, result.getPrice());
        assertEquals(description, result.getDescription());
        assertEquals(name, result.getName());
    }


    @Test
    public void editProduct_should_throw_ifProductNotFound(){
        // Arrange
        String objectId = "68ea2deefcc02c72f4663560";
        when(repository.findById(any())).thenReturn(Optional.empty());

        // Act
        ProductNotFoundException productNotFoundException =  assertThrows(ProductNotFoundException.class, () -> {
            service.editProduct(new EditProductDto(objectId, "", 0d, "", ""));
        });

        // Assert
        assertEquals(objectId, productNotFoundException.getProductId());
    }
}
