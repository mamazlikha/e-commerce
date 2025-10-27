package anas.commerce.cartservice.service;

import anas.commerce.cartservice.contracts.repositories.ICartRepository;
import anas.commerce.cartservice.dtos.CartDto;
import anas.commerce.cartservice.dtos.ItemDTO;
import anas.commerce.cartservice.entities.CartEntity;
import anas.commerce.cartservice.entities.ItemEntity;
import anas.commerce.cartservice.exceptions.CartNotFoundException;
import anas.commerce.cartservice.services.GetCartByUserIdService;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GetCartByUserIdServiceTest {

    @Autowired
    GetCartByUserIdService service;
    @MockBean
    ICartRepository repository;


    @Test
    public void getCartByUserId_should_returnByUserId(){
        // Arrange
        ObjectId cartId = new ObjectId("68f4d2e5263b1321dda21aa8");
        ObjectId productId = new ObjectId("68f4e4f80be1a1d4f8c3585f");
        Set<ItemEntity> items = new HashSet<>();
        items.add(new ItemEntity(new ObjectId("68f4e4e8c30e5844655c5863"), productId));
        items.add(new ItemEntity(new ObjectId("68f4e5263a6affc784fef933"), productId));
        double total = 10d;
        CartEntity cartEntity = new CartEntity(cartId, items, total);
        when(repository.findById(any())).thenReturn(Optional.of(cartEntity));

        // Act
        CartDto result = service.getCartByUserId(cartId);

        // Assert
        assertNotNull(result);
        assertEquals(cartId.toString(), result.getId());
        assertEquals(total, result.getTotalPrice(), 0.01);
        assertEquals(2, result.getItemsDto().size());
        List<ItemDTO> itemDTOList = result.getItemsDto().stream().toList();
        List<ItemEntity> itemsList = items.stream().toList();
        for(int i = 0; i<2; i++){
            assertEquals(itemsList.get(i).getProductEntityId().toString(), itemDTOList.get(i).getProductEntityId());
            assertEquals(itemsList.get(i).getId().toString(), itemDTOList.get(i).getId());
        }
    }

    @Test
    public void getCartByUserId_should_throw_ifInvalidUserId(){
        // Arrange
        ObjectId objectId = new ObjectId("68f4d2e5263b1321dda21aa8");
        when(repository.findById(any())).thenReturn(Optional.empty());

        // Act
        CartNotFoundException productAlreadyExistException =  assertThrows(CartNotFoundException.class, () -> {
            service.getCartByUserId(objectId);
        });

        // Assert
        assertEquals(objectId, productAlreadyExistException.getId());
    }
}
