package anas.commerce.items.entities;

import com.mongodb.lang.NonNull;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document("product")
public class ProductEntity {

    @Id
    @GeneratedValue
    private ObjectId id;

    @NonNull
    private String supplierProductNumber;

    @NonNull
    private String description;

    @NonNull
    private String name;

    @NonNull
    private double price;

}
