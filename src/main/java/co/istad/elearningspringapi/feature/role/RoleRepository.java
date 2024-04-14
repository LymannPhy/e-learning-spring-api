package co.istad.elearningspringapi.feature.role;

import co.istad.elearningspringapi.domain.Role;
import co.istad.elearningspringapi.feature.role.dto.RoleAuthorityResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);


}
