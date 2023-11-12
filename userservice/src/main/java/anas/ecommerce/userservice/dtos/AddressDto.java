package anas.ecommerce.userservice.dtos;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AddressDto {

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
