package co.istad.elearningspringapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String alias;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "ins_id")
    private Instructor instructor;

    private Boolean isDeleted;

    private Boolean isFree;

    private String thumbnail;

    @Column(nullable = false)
    private String title;

}

