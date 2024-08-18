package anas.ecommerce.userservice.dtos;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
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
