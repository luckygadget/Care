package care.connect.care.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import care.connect.care.enums.Gender;
import care.connect.care.enums.Role;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRequestDto {


    @NotBlank(message = "First Name is required")
    private String firstName;
    @NotBlank(message = "Last Name is required")
    private String lastName;

    @Email(message = "Invalid email format")
    private String email;


    @NotBlank(message = "Phone Number is Required")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid Phone Number")
    private String phoneNumber;


    @Size(min = 3, max = 10, message = "Password msut be between 3 and 10")
    private String password;

    private Gender gender;

    private LocalDate dateOfBirth;

    private Role role;

    private AddressRequestDto address;


}
