package care.connect.care.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "addresses")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;

    private String street;
    private String city;
    private String state;
    private String pincode;
    private String country;
    private String addressType;  // e.g., "Home", "Work"

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

