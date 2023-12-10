package anas.commerce.cartservice.controllers;


import anas.commerce.cartservice.contracts.ICreateCartForUserService;
import anas.commerce.cartservice.dtos.CartDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CreateCartForUserControllerTest {


    @InjectMocks
    private CreateCartForUserController createCartForUserController;

    @Mock
    private ICreateCartForUserService createCartForUserService;

    @Test
    public void createCartForUserTest_cartServiceRespondOk_shouldCreateNewCartForUser(){
        // Arrange
        CartDto mockResponse = new CartDto();
        when(createCartForUserService.createNewCart()).thenReturn(mockResponse);

        // Act
        ResponseEntity<CartDto> response = createCartForUserController.createCartForUser();

        // Assert
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertNotNull(response.getBody());

    }

}
