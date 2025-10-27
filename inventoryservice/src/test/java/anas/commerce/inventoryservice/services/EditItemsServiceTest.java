package anas.commerce.inventoryservice.services;

import anas.commerce.inventoryservice.contracts.repositories.IItemsRepository;
import anas.commerce.inventoryservice.dtos.ItemDto;
import anas.commerce.inventoryservice.entities.ItemEntity;
import anas.commerce.inventoryservice.exceptions.ItemNotFoundException;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EditItemsServiceTest {

    @Autowired
    EditItemsService service;

    @MockBean
    IItemsRepository repository;

    @Test
    public void editItem_should_success(){
        // Arrange
        String itemId = "68ebcfa994c8b11a2dace3a0";
        String newProductId = "68ebd0c64ef7501d2f74c377";
        String productId = "68ebcf13aeedd97aa7e6a5e3";
        ItemDto newItemDto = ItemDto.builder().id(itemId).productEntityId(newProductId).build();
        ItemEntity existingItemEntity = new ItemEntity(new ObjectId(itemId), new ObjectId(productId));
        ItemEntity newItemEntity = new ItemEntity(new ObjectId(itemId), new ObjectId(newProductId));
        when(repository.findById(any())).thenReturn(Optional.of(existingItemEntity));
        when(repository.save(any())).thenReturn(newItemEntity);

        // Act
        ItemDto result = service.editItem(newItemDto);

        // Assert
        assertNotNull(result);
        assertEquals(newItemDto.getId(), result.getId());
        assertEquals(newItemDto.getProductEntityId(), result.getProductEntityId());
    }


    @Test
    public void editItem_should_throw_ifNoItemInDatabase() {
        // Arrange
        String itemId = "68ebcfa994c8b11a2dace3a0";
        ItemDto newItemDto = new ItemDto(itemId, "f4564fs56qf456qs");
        when(repository.findById(any())).thenReturn(Optional.empty());

        // Act
        ItemNotFoundException itemNotFoundException =  assertThrows(ItemNotFoundException.class, () -> {
            service.editItem(newItemDto);
        });

        // Assert
        Assert.assertEquals(itemId, itemNotFoundException.getId());
    }

}

