package co.istad.elearningspringapi.feature.student;

import co.istad.elearningspringapi.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findById(Long id);
}
