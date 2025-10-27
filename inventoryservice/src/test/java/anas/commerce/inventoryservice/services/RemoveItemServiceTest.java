package anas.commerce.inventoryservice.services;

import anas.commerce.inventoryservice.contracts.repositories.IItemsRepository;
import anas.commerce.inventoryservice.entities.ItemEntity;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RemoveItemServiceTest {

    @Autowired
    RemoveItemService service;

    @MockBean
    IItemsRepository repository;

    @Test
    public void decreaseProductQuantity_should_success(){
        // Arrange
        ObjectId itemId = new ObjectId("68ebcfa994c8b11a2dace3a0");
        String productId = "68ebcf13aeedd97aa7e6a5e3";
        ItemEntity itemToRemove = new ItemEntity(itemId, new ObjectId(productId));
        when(repository.findById(itemId)).thenReturn(Optional.of(itemToRemove));
        doNothing().when(repository).delete(any());

        // Act
        Integer result = service.decreaseProductQuantity(itemId, new ObjectId(productId));

        // Assert
        assertEquals(1, result);
    }
}
