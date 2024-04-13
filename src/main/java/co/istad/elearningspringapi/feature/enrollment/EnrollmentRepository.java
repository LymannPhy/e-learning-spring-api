package co.istad.elearningspringapi.feature.enrollment;


import co.istad.elearningspringapi.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    Optional<Enrollment> findById(Integer id);
}
