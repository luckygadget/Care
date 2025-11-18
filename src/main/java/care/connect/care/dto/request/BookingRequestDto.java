package care.connect.care.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class BookingRequestDto {

    @NotNull
    private Long userId;
    @NotNull
    private Long maidId;
    @NotNull
    private LocalDateTime bookingStartTime;
    @NotNull
    private LocalDateTime bookingEndTime;
    private String notes;
    private AddressRequestDto serviceAddress;
    @NotNull
    private care.connect.care.enums.models.Status status;  // PENDING, ACCEPTED, COMPLETED, CANCELLED
}

