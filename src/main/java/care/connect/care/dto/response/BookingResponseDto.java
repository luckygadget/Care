package care.connect.care.dto.response;

import java.time.LocalDateTime;

public class BookingResponseDto {

    private Long id;

    private Long userId;

    private Long maidId;

    private LocalDateTime bookingStartTime;

    private LocalDateTime bookingEndTime;

    private String notes;

    private care.connect.care.enums.models.Status status;

    private Double totalAmount;

    private AddressResponseDto serviceAddress;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

