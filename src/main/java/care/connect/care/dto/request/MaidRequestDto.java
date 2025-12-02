package care.connect.care.dto.request;

import care.connect.care.enums.Availability;
import care.connect.care.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import care.connect.care.enums.Skills;
import lombok.Data;

import java.util.List;

@Data
public class MaidRequestDto {

    @NotBlank
    private String fullName;

    @NotBlank
    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String phoneNumber;

    private String bio;

    private Gender gender;

    @NotNull
    private List<Skills> skills;  // COOKING, CLEANING, BABYSITTING, etc.

    @NotNull
    private Availability availability; // FULL_TIME, PART_TIME, HOURLY

    @NotNull
    private Double hourlyRate;

    private Integer experienceInYears;

    private AddressRequestDto address;  // Maid's address (optional)
}
