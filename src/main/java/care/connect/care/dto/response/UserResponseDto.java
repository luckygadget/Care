package care.connect.care.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import care.connect.care.enums.models.Role;
import lombok.Data;




@Data
public class UserResponseDto {

    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private care.connect.care.enums.models.Gender gender;

    private LocalDate dateOfBirth;

    private Role role;

    private String profileImageUrl;

    private AddressResponseDto address;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

