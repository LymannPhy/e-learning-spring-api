package co.istad.elearningspringapi.features.courses;
import co.istad.elearningspringapi.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CourseRepository extends JpaRepository<Course,Long> {
    Boolean existsByAlias (String alias);
}
