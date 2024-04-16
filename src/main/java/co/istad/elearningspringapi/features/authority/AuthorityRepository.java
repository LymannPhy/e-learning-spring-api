package co.istad.elearningspringapi.features.authority;

import co.istad.elearningspringapi.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
