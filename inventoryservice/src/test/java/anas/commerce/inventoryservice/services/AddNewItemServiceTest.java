package anas.commerce.inventoryservice.services;

import anas.commerce.inventoryservice.contracts.repositories.IItemsRepository;
import anas.commerce.inventoryservice.entities.ItemEntity;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AddNewItemServiceTest {
    @InjectMocks
    AddNewItemService service;

    @Mock
    IItemsRepository repository;

    @Test
    public void increaseProductQuantity_should_addItem(){
        // Arrange
        ObjectId id = new ObjectId("68ebc1166ef7e67d26f10eee");
        ItemEntity itemEntity = new ItemEntity(id);
        when(repository.save(any())).thenReturn(itemEntity);

        // Act
        boolean result = service.increaseProductQuantity(id);

        // Assert
        assertTrue(result);
    }
}
