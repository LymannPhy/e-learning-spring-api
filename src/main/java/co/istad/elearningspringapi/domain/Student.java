package co.istad.elearningspringapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String highSchool;

    private Boolean isBlocked;

    private String university;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}

