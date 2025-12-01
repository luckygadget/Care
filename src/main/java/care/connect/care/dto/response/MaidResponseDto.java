package care.connect.care.dto.response;

import care.connect.care.enums.Availability;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class MaidResponseDto {

    private String maidId;

    private String fullName;

    private String phoneNumber;

    private String bio;

    private care.connect.care.enums.models.Gender gender;

    private List<care.connect.care.enums.models.Skills> skills;

    private Availability availability;

    private Double hourlyRate;

    private Integer experienceInYears;

    private Double rating; // calculated from reviews

    private Integer totalBookingsCompleted;

    private AddressResponseDto address;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

