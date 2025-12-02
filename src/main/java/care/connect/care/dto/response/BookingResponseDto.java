package care.connect.care.dto.response;

import care.connect.care.enums.Status;
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

    private Status status;

    private Double totalAmount;

    private AddressResponseDto serviceAddress;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

