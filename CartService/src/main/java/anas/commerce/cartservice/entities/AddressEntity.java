package anas.commerce.cartservice.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("address")
public class AddressEntity {


    private int streetNumber;

    private String streetName;

    private String zipCode;

    private String city;

    private String country;
}
