package co.istad.elearningspringapi.features.student;

import co.istad.elearningspringapi.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByUserUsername(String username);
    Optional<Student> findById(Long id);
}
