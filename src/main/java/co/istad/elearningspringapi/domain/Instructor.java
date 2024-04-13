package co.istad.elearningspringapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String biography;

    private String github;

    private Boolean isBlocked;

    private String jobTitle;

    private String linkedIn;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String website;

}

