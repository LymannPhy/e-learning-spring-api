package co.istad.elearningspringapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String givenName;

    private String familyName;

    private LocalDate dob;

    private String gender;

    private String address1;

    private String address2;

    private String phoneNumber;

    private Boolean isVerified;

    private String verifiedCode;

    private Boolean isDeleted;

    private String nationalIdCard;

    private String profile;

    @OneToOne(mappedBy = "user")
    private Instructor instructor;

    @OneToOne(mappedBy = "user")
    private Student student;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}

