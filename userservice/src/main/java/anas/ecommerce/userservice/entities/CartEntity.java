package anas.ecommerce.userservice.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Document("cart")
public class CartEntity {
    @Id
    @GeneratedValue
    private ObjectId id;

    @OneToMany(mappedBy="cart", fetch = FetchType.LAZY)
    @NonNull
    private Set<ItemEntity> items;

    @NonNull
    private double totalPrice;

}
