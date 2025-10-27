package anas.commerce.cartservice.service;

import anas.commerce.cartservice.contracts.repositories.ICartRepository;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.entities.ItemEntity;
import anas.commerce.cartservice.services.RemoveItemFromCartService;
import anas.ecommerce.client.ApiException;
import anas.ecommerce.client.api.GetProductByIdControllerApi;
import anas.ecommerce.client.model.ProductDTO;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RemoveItemFromCartServiceTest {

    @Autowired
    RemoveItemFromCartService service;

    @MockBean
    ICartRepository repository;

    @MockBean
    GetProductByIdControllerApi mockedApi;

    @Before
    public void setup(){
        mockedApi = Mockito.mock(GetProductByIdControllerApi.class);
        service.setGetProductByIdControllerApi(mockedApi);
    }

    @Test
    public void removeItem_should_removeItemFromCart() throws ApiException {
        // Arrange
        ObjectId cartId = new ObjectId("68f4d2e5263b1321dda21aa8");
        ObjectId productId = new ObjectId("68f4e4f80be1a1d4f8c3585f");
        Set<ItemEntity> items = new HashSet<>();
        ProductDTO mockedResponse = new ProductDTO();
        mockedResponse.setPrice(5d);
        items.add(new ItemEntity(new ObjectId("68f4e4e8c30e5844655c5863"), productId));
        items.add(new ItemEntity(new ObjectId("68f4e5263a6affc784fef933"), productId));
        double total = 10d;
        CartEntity cartEntity = new CartEntity(cartId, items, total);
        when(repository.findById(any())).thenReturn(Optional.of(cartEntity));
        when(mockedApi.getProductById(any())).thenReturn(mockedResponse);
        when(repository.save(any())).thenReturn(new CartEntity());

        // Act
        boolean result = service.removeItem(cartId, new ObjectId("68f4e4e8c30e5844655c5863"));

        // Assert
        assertTrue(result);
    }


    @Test
    public void removeItem_should_not_removeItemFromCart_ifItemNotExist(){
        // Arrange
        when(repository.findById(any())).thenReturn(Optional.empty());

        // Act
        boolean result = service.removeItem(new ObjectId("68f4e7e8327de1b6e4ec4551"), new ObjectId("68f4e7f1038580ba101b92ed"));

        // Assert
        assertFalse(result);
    }

}
