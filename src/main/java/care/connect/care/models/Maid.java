package care.connect.care.models;


import care.connect.care.enums.Availability;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "maids")
@Data
public class Maid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maid_id;

    private String experience;
    @Enumerated(EnumType.STRING)
    private care.connect.care.enums.models.Skills skills;

    @Enumerated(EnumType.STRING)
    private Availability availability;

    private Double hourlyRate;
    private Double rating;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @OneToMany(mappedBy = "maid", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();


}
