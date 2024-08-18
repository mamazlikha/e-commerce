package anas.ecommerce.userservice.entities;

import com.mongodb.lang.NonNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Document("user")
public class UserEntity {

    @Id
    @GeneratedValue
    private ObjectId id;

    @NonNull
    private String firstname;

    @NonNull
    private String lastname;

    @NonNull
    private LocalDate birthdate;

    @NonNull
    private String email;

    @NonNull
    private String phoneNumber;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private CartEntity userCart;

    @NonNull
    private AddressEntity address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity entity)) return false;
        return Objects.equals(email, entity.email) || Objects.equals(phoneNumber, entity.phoneNumber) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, phoneNumber);
    }
}
