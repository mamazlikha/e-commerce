package anas.commerce.items.services;

import anas.commerce.items.contracts.repositories.IProductsRepository;
import anas.commerce.items.entities.ProductEntity;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeleteProductByIdServiceTest {
    @Autowired
    DeleteProductByIdService service;

    @MockBean
    IProductsRepository repository;

    @Test
    public void deleteById_should_deleteProduct(){
        // Arrange
        ProductEntity toDelete = new ProductEntity();
        when(repository.findById(any())).thenReturn(Optional.of(toDelete));
        doNothing().when(repository).deleteById(any());

        // Act
        boolean result = service.deleteById(new ObjectId("68ea1111279ffadb9adb840d"));

        // Assert
        assertTrue(result);
    }


    @Test
    public void deleteById_should_notDeleteProduct(){
        // Arrange
        when(repository.findById(any())).thenReturn(Optional.empty());

        // Act
        boolean result = service.deleteById(new ObjectId("68ea1111279ffadb9adb840d"));

        // Assert
        assertFalse(result);
    }
}
