package care.connect.care.dto.response;

import java.time.LocalDateTime;

public class BookingResponseDto {

    private String booking_id;

    private String user_id;

    private String maid_id;

    private LocalDateTime bookingStartTime;

    private LocalDateTime bookingEndTime;

    private String notes;

    private care.connect.care.enums.models.Status status;

    private Double totalAmount;

    private AddressResponseDto serviceAddress;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

