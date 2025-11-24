package care.connect.care.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class AddressRequestDto {

    @NotBlank
    private String street;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String country;

    @NotBlank
    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Invalid Indian PIN code")
    private String postalCode;
}
