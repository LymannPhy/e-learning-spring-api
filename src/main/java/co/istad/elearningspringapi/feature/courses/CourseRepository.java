package co.istad.elearningspringapi.feature.courses;

import co.istad.elearningspringapi.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByid(Long id);

}
