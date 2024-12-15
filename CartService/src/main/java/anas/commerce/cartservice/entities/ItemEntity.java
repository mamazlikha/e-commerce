package anas.commerce.cartservice.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import java.util.Objects;

@Data
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


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (this == obj) return true;

        if (getClass() != obj.getClass())
            return false;

        ItemEntity entity = (ItemEntity) obj;
        return this.id.equals(entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
