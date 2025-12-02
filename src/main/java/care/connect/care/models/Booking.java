package care.connect.care.models;

import care.connect.care.models.Maid;
import care.connect.care.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    private String bookingId;

    private LocalDateTime bookingDate;
    private LocalDateTime serviceDate;
    private String status;        // e.g., "PENDING", "CONFIRMED", "COMPLETED"
    private Double totalAmount;

    private String notes;

    @ManyToOne
    @JoinColumn(name = "userId")  // Customer who made the booking
    private User user;

    @ManyToOne
    @JoinColumn(name = "maidId")  // Maid assigned to the booking
    private Maid maid;

    // Getters and Setters
}
