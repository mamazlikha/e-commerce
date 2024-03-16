package anas.ecommerce.userservice.dtos.userdto;

import anas.ecommerce.userservice.dtos.AddressDto;
import com.mongodb.lang.NonNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
    private String email;

    @NonNull
    private String phoneNumber;

    @NonNull
    private AddressDto userAddressDto;


}
