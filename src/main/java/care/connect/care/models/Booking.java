package care.connect.care.models;

import care.connect.care.models.Maid;
import care.connect.care.models.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long booking_id;

    private LocalDateTime bookingDate;
    private LocalDateTime serviceDate;
    private String status;        // e.g., "PENDING", "CONFIRMED", "COMPLETED"
    private Double totalAmount;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "user_id")  // Customer who made the booking
    private User user;

    @ManyToOne
    @JoinColumn(name = "maid_id")  // Maid assigned to the booking
    private Maid maid;

    // Getters and Setters
}
