package anas.ecommerce.userservice.dtos.userdto;

import anas.ecommerce.userservice.dtos.AddressDto;
import anas.ecommerce.userservice.dtos.CartDto;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class CreateUserDto extends UserDto {

    private CartDto userCartDto;

    public CreateUserDto(String firstname, String lastname, LocalDate birthdate, @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format") String email, String phoneNumber, AddressDto userAddressDto) {
        super(firstname, lastname, birthdate, email, phoneNumber, userAddressDto);
    }
}
