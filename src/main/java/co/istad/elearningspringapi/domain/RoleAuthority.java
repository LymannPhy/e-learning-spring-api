package co.istad.elearningspringapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles_authorities")
public class RoleAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "authorities_id")
    private Authority authority;

    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Role role;
}

