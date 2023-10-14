package anas.commerce.cartservice.entities;

import com.mongodb.lang.NonNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import java.math.BigInteger;

@Getter
@Setter
@Document("item")
public class ItemEntity {

    @Id
    @GeneratedValue
    private BigInteger id;


    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private double price;


    @NonNull
    private int quantity;

}
