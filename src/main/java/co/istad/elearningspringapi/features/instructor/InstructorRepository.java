package co.istad.elearningspringapi.features.instructor;

import co.istad.elearningspringapi.domain.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}
