package co.istad.elearningspringapi.features.courses;
import co.istad.elearningspringapi.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
public interface CourseRepository extends JpaRepository<Course,Long> {
    Boolean existsByAlias (String alias);
    Optional< Course > findByAlias (String alias);

    @Modifying
    @Query("update Course AS c set c.thumbnail = ?2 where c.alias =?1")
    void updateThumbnail (String alias, String thumbnail);

    Optional<Course> findAllByAlias (String alias);

}
