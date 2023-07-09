package anas.commerce.cartservice.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import java.math.BigInteger;
import java.util.Set;

@Getter
@Setter
@Document("cart")
public class CartEntity {
    @Id
    @GeneratedValue
    private BigInteger id;

    @OneToMany(mappedBy="cart")
    private Set<ItemEntity> items;

    private double totalPrice;

}
