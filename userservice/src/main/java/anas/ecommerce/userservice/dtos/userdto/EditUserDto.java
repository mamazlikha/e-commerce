package anas.ecommerce.userservice.dtos.userdto;

import anas.ecommerce.userservice.dtos.AddressDto;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EditUserDto extends UserDto {

    public EditUserDto(String id, String firstname, String lastname, LocalDate birthdate, @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format") String email, String phoneNumber, AddressDto userAddressDto) {
        super(firstname, lastname, birthdate, email, phoneNumber, userAddressDto);
        this.setId(id);
    }
}
