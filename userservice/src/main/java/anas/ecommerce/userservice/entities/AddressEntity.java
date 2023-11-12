package anas.ecommerce.userservice.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@RequiredArgsConstructor
@Document("address")
public class AddressEntity {

    @NonNull
    private int streetNumber;

    @NonNull
    private String streetName;

    @NonNull
    private String zipCode;

    @NonNull
    private String city;

    @NonNull
    private String country;
}
