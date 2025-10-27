package anas.commerce.cartservice.service;

import anas.commerce.cartservice.contracts.repositories.ICartRepository;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.services.CreateCartForUserService;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CreateCartForUserServiceTest {

    @Autowired
    CreateCartForUserService service;

    @MockBean
    ICartRepository repository;


    @Test
    public void createNewCart_should_success(){
        // Arrange
        ObjectId objectId = new ObjectId("68f4d2e5263b1321dda21aa8");
        CartEntity cartEntity = new CartEntity(objectId, new HashSet<>(), 0);
        when(repository.save(any())).thenReturn(cartEntity);

        // Act
        CartDto result = service.createNewCart();

        // Assert
        assertNotNull(result);
        assertEquals(0, result.getItemsDto().size());
        assertEquals(objectId.toString(), result.getId());
        assertEquals(0, result.getTotalPrice());
    }
}
