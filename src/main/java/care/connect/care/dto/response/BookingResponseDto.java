package care.connect.care.dto.response;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class BookingResponseDto {

    private String bookingId;

    private String userId;

    private String maidId;

    private LocalDateTime bookingStartTime;

    private LocalDateTime bookingEndTime;

    private String notes;

    private care.connect.care.enums.models.Status status;

    private Double totalAmount;

    private AddressResponseDto serviceAddress;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

