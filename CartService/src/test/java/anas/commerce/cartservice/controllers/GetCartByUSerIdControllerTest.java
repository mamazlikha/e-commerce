package anas.commerce.cartservice.controllers;


import anas.commerce.cartservice.contracts.IGetCartByUSerIdService;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.exceptions.CartNotFoundException;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class GetCartByUSerIdControllerTest {


    @InjectMocks
    private GetCartByUSerIdController getCartByUSerIdController;

    @Mock
    private IGetCartByUSerIdService getCartByUSerIdService;

    @Test
    public void getCartByIdTest_validCartId_shouldReturnValidCartDto(){
        // Arrange
        String cartId = "507f191e810c19729de860ea";
        CartDto mockResponse = new CartDto("newid", new HashSet<>(), 0);
        when(getCartByUSerIdService.getCartByUserId(new ObjectId(cartId))).thenReturn(mockResponse);

        // Act
        ResponseEntity<CartDto> response = getCartByUSerIdController.getCartById(cartId);

        // Assert
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
        assertEquals(response.getBody().getId(), mockResponse.getId());
        assertEquals(response.getBody().getItemsDto().size(), 0);

    }

    @Test
    public void getCartByIdTest_notValidCartId_shouldThrowCartNotFoundException() {
        // Arrange
        String cartId = "507f191e810c19729de860ea";
        when(getCartByUSerIdService.getCartByUserId(new ObjectId(cartId))).thenThrow(CartNotFoundException.class);

        // Act
        ResponseEntity<CartDto> response = getCartByUSerIdController.getCartById(cartId);

        // Assert
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
        assertNull(response.getBody());
    }

}
