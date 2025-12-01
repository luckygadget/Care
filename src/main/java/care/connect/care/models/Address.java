package care.connect.care.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    private String addressId;

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

