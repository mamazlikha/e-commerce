package anas.commerce.items.services;

import anas.commerce.items.contracts.repositories.IProductsRepository;
import anas.commerce.items.dtos.CreateProductDto;
import anas.commerce.items.entities.ProductEntity;
import anas.commerce.items.exceptions.ProductAlreadyExistException;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddNewProductServiceTest {

    @Autowired
    AddNewProductService addNewProductService;

    @MockBean
    IProductsRepository repository;

    @Test
    public void addNewProduct_should_addNewProduct(){
        // Arrange
        String objectId = "68ea1111279ffadb9adb840d";
        String supplierNumber = "423DSQT43DFSQD43";
        double price = 10.5d;
        String name = "cleaner";
        String description = "This is a new cleaner";
        CreateProductDto newProductMock = new CreateProductDto(supplierNumber, price, name, description);
        when(repository.findBySupplierProductNumber(anyString())).thenReturn(Optional.empty());
        when(repository.save(any())).thenReturn(new ProductEntity(new ObjectId(objectId), supplierNumber, description, name, price));

        // Act
        CreateProductDto result = addNewProductService.addNewProduct(new CreateProductDto(supplierNumber, price, name, description));

        // Assert
        assertNotNull(result);
        assertEquals(newProductMock.getName(), result.getName());
        assertEquals(newProductMock.getPrice(), result.getPrice(), 0.01);
        assertEquals(newProductMock.getDescription(), result.getDescription());
    }

    @Test
    public void addNewProduct_should_throw_ifProductAlreadyExist(){
        // Arrange
        String objectId = "68ea1111279ffadb9adb840d";
        String supplierNumber = "423DSQT43DFSQD43";
        double price = 10.5d;
        String name = "cleaner";
        String description = "This is a new cleaner";
        ProductEntity existedProduct = new ProductEntity(new ObjectId(objectId), supplierNumber, description, name, price);
        when(repository.findBySupplierProductNumber(anyString())).thenReturn(Optional.of(existedProduct));

        // Act
        ProductAlreadyExistException productAlreadyExistException =  assertThrows(ProductAlreadyExistException.class, () -> {
            addNewProductService.addNewProduct(new CreateProductDto(supplierNumber, price, name, description));
        });

        // Assert
        assertEquals(supplierNumber, productAlreadyExistException.getSupplierNumber());
    }
}
