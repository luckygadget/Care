package care.connect.care.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class BookingRequestDto {

    @NotNull
    private String userId;
    @NotNull
    private String maidId;
    @NotNull
    private LocalDateTime bookingStartTime;
    @NotNull
    private LocalDateTime bookingEndTime;
    private String notes;
    private AddressRequestDto serviceAddress;
    @NotNull
    private care.connect.care.enums.models.Status status;  // PENDING, ACCEPTED, COMPLETED, CANCELLED
}

