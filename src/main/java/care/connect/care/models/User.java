package care.connect.care.models;


import care.connect.care.enums.Role;
import care.connect.care.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name= "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String userId;
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
    private Status status;

    private LocalDateTime  createdAt;
    private LocalDateTime  updatedAt;
    private LocalDateTime  lastLoginAt;
    private boolean isVerified;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Maid maidProfile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    private Role role;








}
