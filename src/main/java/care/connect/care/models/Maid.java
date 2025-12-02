package care.connect.care.models;


import care.connect.care.enums.Availability;
import care.connect.care.enums.Skills;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "maids")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Maid {

    @Id
    private String maidId;

    private String experience;
    @Enumerated(EnumType.STRING)
    private Skills skills;

    @Enumerated(EnumType.STRING)
    private Availability availability;

    private Double hourlyRate;
    private Double rating;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @OneToMany(mappedBy = "maid", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();


}
