package anas.commerce.items.entities;

import com.mongodb.lang.NonNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Document("product")
public class ProductEntity {

    @Id
    @GeneratedValue
    private ObjectId id;

    @NonNull
    private String supplierNumber;

    @NonNull
    private String description;

    @NonNull
    private String name;

    @NonNull
    private double price;

}
