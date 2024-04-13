package co.istad.elearningspringapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String alias;

    private String icon;

    @Column(nullable = false,length = 60,unique = true)
    private String name;

    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "parent_categories_id")
    private Category parentCategory;
}

