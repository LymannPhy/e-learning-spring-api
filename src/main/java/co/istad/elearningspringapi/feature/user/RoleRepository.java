package co.istad.elearningspringapi.feature.user;

import co.istad.elearningspringapi.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String instructor);
}
