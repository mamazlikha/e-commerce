package anas.commerce.cartservice.entities;

import com.mongodb.lang.NonNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.GeneratedValue;


@Getter
@Setter
@RequiredArgsConstructor
@Document("user")
public class UserEntity {

    @Id
    @GeneratedValue
    private ObjectId id;

    @NonNull
    private String firstname;

    @NonNull
    private String lastname;

    private int age;

    @NonNull
    private String email;

    @NonNull
    private String phoneNumber;

    @NonNull
    private AddressEntity address;

}
