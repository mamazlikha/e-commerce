package anas.ecommerce.userservice.dtos;

import com.mongodb.lang.NonNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {

    private String id;

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

    @NonNull
    private AddressDto userAddressDto;

    private CartDto userCartDto;

}
