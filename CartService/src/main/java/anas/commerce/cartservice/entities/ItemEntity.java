package anas.commerce.cartservice.entities;

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
@RequiredArgsConstructor
@NoArgsConstructor
@Document("item")
public class ItemEntity {

    @Id
    @GeneratedValue
    private ObjectId id;


    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private double price;


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (this == obj) return true;

        if (getClass() != obj.getClass())
            return false;

        ItemEntity entity = (ItemEntity) obj;
        return this.name.equals(entity.name) && this.description.equals(entity.description) && this.price == entity.price;
    }
}
