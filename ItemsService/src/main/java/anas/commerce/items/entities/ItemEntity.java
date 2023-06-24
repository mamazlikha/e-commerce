package anas.commerce.items.entities;

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
    public BigInteger id;

    public String description;

    public long price;




}
