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
@Document("user")
public class UserEntity {

    @Id
    @GeneratedValue
    private BigInteger id;

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
    private Address address;

}
