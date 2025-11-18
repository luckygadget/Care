package care.connect.care.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private String phoneNumber;
    private String password;
    private String gender;
    private LocalDateTime dateOfBirth;
    private String profileImageUrl;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> address = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private care.connect.care.enums.models.Status status;

    private LocalDateTime  createdAt;
    private LocalDateTime  updatedAt;
    private LocalDateTime  lastLoginAt;
    private boolean isVerified;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Maid maidProfile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    private care.connect.care.enums.models.Role role;








}
