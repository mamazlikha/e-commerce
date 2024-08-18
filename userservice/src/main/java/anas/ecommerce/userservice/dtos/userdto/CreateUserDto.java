package anas.ecommerce.userservice.dtos.userdto;

import anas.ecommerce.userservice.dtos.AddressDto;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openapitools.client.model.CartDto;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto extends UserDto {

    private CartDto userCartDto;

    public CreateUserDto(String firstname, String lastname, LocalDate birthdate, @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format") String email, String phoneNumber, AddressDto userAddressDto) {
        super(firstname, lastname, birthdate, email, phoneNumber, userAddressDto);
    }
}
