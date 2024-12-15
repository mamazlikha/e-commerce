package anas.commerce.inventoryservice.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Document("item")
public class ItemEntity {


    @Id
    @GeneratedValue
    private ObjectId id;


    @NonNull
    private ObjectId productEntityId;

    @NonNull
    private String supplierNumber;

}
