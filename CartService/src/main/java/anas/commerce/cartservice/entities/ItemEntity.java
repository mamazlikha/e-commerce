package anas.commerce.cartservice.entities;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.math.BigInteger;

public class ItemEntity {

    @Id
    @GeneratedValue
    private BigInteger id;

    @NonNull
    private int quantity;

    @NonNull
    private String description;

    @NonNull
    private double price;


}
