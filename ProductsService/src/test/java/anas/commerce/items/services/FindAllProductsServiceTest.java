package anas.commerce.items.services;

import anas.commerce.items.contracts.repositories.IProductsRepository;
import anas.commerce.items.dtos.ProductDTO;
import anas.commerce.items.entities.ProductEntity;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FindAllProductsServiceTest {

    @Autowired
    FindAllProductsService service;

    @MockBean
    IProductsRepository repository;

    @Test
    public void findAll_should_return(){
        // Arrange
        List<ProductEntity> entities = new ArrayList<>();
        entities.add(new ProductEntity(new ObjectId("68ea2deefcc02c72f4663560"), "ea4e4z435az", "test description", "name 1", 54.2d));
        when(repository.findAll()).thenReturn(entities);

        // Act
        List<ProductDTO> result = service.findAll();

        // Assert
        assertEquals(entities.size(), result.size());
        for(int i = 0 ; i<entities.size(); i++){
            assertEquals(entities.get(i).getName(), result.get(i).getName());
            assertEquals(entities.get(i).getDescription(), result.get(i).getDescription());
            assertEquals(entities.get(i).getPrice(), result.get(i).getPrice(), 0.01);
        }
    }

}
