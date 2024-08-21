package anas.ecommerce.userservice.dtos.userdto;

import anas.ecommerce.userservice.dtos.AddressDto;
import com.mongodb.lang.NonNull;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String id;

    @NonNull
    private String firstname;

    @NonNull
    private String lastname;

    @NonNull
    private LocalDate birthdate;

    @NonNull
    @Email
    private String email;

    @NonNull
    private String phoneNumber;

    @NonNull
    private AddressDto userAddressDto;


}
