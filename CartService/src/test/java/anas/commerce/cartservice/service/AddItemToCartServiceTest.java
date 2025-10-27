package anas.commerce.cartservice.service;

import anas.commerce.cartservice.contracts.repositories.ICartRepository;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.dtos.ItemDTO;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.entities.ItemEntity;
import anas.commerce.cartservice.services.AddItemToCartService;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddItemToCartServiceTest {

    @Autowired
    AddItemToCartService service;

    @MockBean
    RestTemplate restTemplate;

    @MockBean
    ICartRepository repository;

    @Before
    public void setup() {
        service.setRestTemplate(restTemplate);
        service.setRepository(repository);
    }

    @Test
    public void addItem_should_success() {
        // Arrange
        double total = 15d;
        String productEntityId = "68eb9007bd70789d50b97c64";
        ObjectId cartId = new ObjectId("68eb7a09c6b9ef5b10efc3a0");
        String itemId = "68eb9167528acf261a3b374b";
        CartEntity mockedCartEntity = new CartEntity(cartId, new HashSet<>(), 0d);
        CartEntity itemInCartEntity = new CartEntity(cartId, new HashSet<>(), total);
        itemInCartEntity.getItems().add(new ItemEntity(new ObjectId(itemId), new ObjectId(productEntityId)));
        ItemDTO dto = new ItemDTO(itemId, productEntityId);
        when(repository.findById(cartId)).thenReturn(Optional.of(mockedCartEntity));
        when(repository.save(any())).thenReturn(itemInCartEntity);
        when(restTemplate.getForEntity(
                ArgumentMatchers.eq("http://localhost:8080/items/"+productEntityId),
                ArgumentMatchers.<Class<ItemDTO>>any()))
                .thenReturn(new ResponseEntity<>(dto, HttpStatus.OK));

        // Act
        CartDto result = service.addItem(cartId, productEntityId);

        // Assert
        assertNotNull(result);
        verify(restTemplate).getForEntity(anyString(), ArgumentMatchers.<Class<ItemDTO>>any());
        assertEquals(1, result.getItemsDto().size());
        assertEquals(total, result.getTotalPrice(), 0.01);
    }
}
