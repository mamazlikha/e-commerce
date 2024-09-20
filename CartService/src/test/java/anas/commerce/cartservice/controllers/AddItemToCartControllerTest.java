package anas.commerce.cartservice.controllers;

import anas.commerce.cartservice.contracts.IAddItemToCartService;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.exceptions.ProductServiceIsInvalidException;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class AddItemToCartControllerTest {

    @InjectMocks
    private AddItemToCartController addItemToCartController;

    @Mock
    private IAddItemToCartService addItemToCartServiceMock;

    @Test
    void addItemTest_normalItem_ShouldReturn201Created() throws Exception {
        // Arrange
        ObjectId cartId = new ObjectId("507f191e810c19729de860ea");
        String itemId = "itemId";
        CartDto mockResponse = new CartDto("newid", new HashSet<>(), 0);
        when(addItemToCartServiceMock.addItem(cartId, itemId)).thenReturn(mockResponse);

        // Act
        ResponseEntity<CartDto> response = addItemToCartController.addItem(cartId.toHexString(), itemId);

        // Assert
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertNotNull(response.getBody());
        assertEquals("newid", response.getBody().getId());
        assertEquals(0, response.getBody().getItemsDto().size());
    }


    @Test
    void addItemTest_addItemServiceThrowsProductServiceIsInvalidException_shouldReturn503(){
        // Arrange
        ObjectId cartId = new ObjectId("507f191e810c19729de860ea");
        String itemId = "itemId";
        CartDto mockResponse = new CartDto("newid", new HashSet<>(), 0);
        when(addItemToCartServiceMock.addItem(cartId, itemId)).thenThrow(ProductServiceIsInvalidException.class);

        // Act
        ResponseEntity<CartDto> response = addItemToCartController.addItem(cartId.toHexString(), itemId);

        // Assert
        assertEquals(response.getStatusCode(), HttpStatus.SERVICE_UNAVAILABLE);
    }


    @Test
    void addItemTest_addItemServiceThrowsRunTimeException_shouldReturn500(){
        // Arrange
        ObjectId cartId = new ObjectId("507f191e810c19729de860ea");
        String itemId = "itemId";
        CartDto mockResponse = new CartDto("newid", new HashSet<>(), 0);
        when(addItemToCartServiceMock.addItem(cartId, itemId)).thenThrow(RuntimeException.class);

        // Act
        ResponseEntity<CartDto> response = addItemToCartController.addItem(cartId.toHexString(), itemId);

        // Assert
        assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
