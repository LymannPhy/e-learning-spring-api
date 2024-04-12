package co.istad.elearningspringapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flag;

    @Column(nullable = false, unique = true)
    private String iso;

    @Column(nullable = false)
    private String name;

    private String niceName;

    private Integer numCode;

    @Column(nullable = false)
    private String phoneCode;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

}


